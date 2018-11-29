using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.IO;
using Common;
using Common.Business_Objects;
using GalaxyCinemas.DataLayer;

namespace GalaxyCinemas
{
    public class MovieImporter : BaseImporter
    {
        public MovieImporter(string filename) : base(filename)
        {
        }
        

        /// <summary>
        /// Import movie file. Filename has been provided in the constructor.
        /// </summary>
        public override void Import(object o)
        {
            // Initialise progress to zero for progress bar.
            Progress = 0f;
            ImportResult results= new ImportResult();
            try
            {
                // Read file
                string fileData = null;
                using (StreamReader reader = File.OpenText(fileName))
                {
                    fileData = reader.ReadToEnd();
                    // Read file  using ReadToEnd

                }
                string[] lines = fileData.Replace("\r\n", "\n").Replace("\r", "\n").Split('\n'); // To deal with Windows, Mac and Linux line endings the same.
                string firstLine = lines[0];
                // Check if first line is column names.
                string[] columns = firstLine.Split(',');
                if (columns.Length == 2)
                {
                    if ((columns[0].ToLower().Trim() == "movieid") && (columns[1].ToLower().Trim() == "title"))
                    {
                        lines[0] = "";
                    }

                }    // Line count and line numbers to allow progress tracking.
                    int lineCount = lines.Length;
                    int lineNum = 1;

                    // Get all movies.
                    List<Movie> movies = DataLayer.DataLayer.GetAllMovies();

                    foreach (string line in lines)
                    {
                        // Check whether we need to stop after importing each line.
                        if (Stop)
                        {
                            return;
                        }
                        try
                        { 
                        // Just to make it slow enough to test stopping functionality.
                        Thread.Sleep(500);

                        // Update progress of import.
                       
                        
                            Progress = lineNum / lineCount;
                            RaiseProgressChanged();



                            // Skip blank lines
                            if (line == "")
                            {
                                continue;
                            }
                            else
                            {
                                results.TotalRows++;
                            }


                            // Break up line by commas, each item in array will be one column.
                            columns = line.Split(',');
                            if (columns.Length != 2)
                            {
                                results.FailedRows++;
                                results.ErrorMessages.Add(string.Format("Line {0}: Wrong number of columns.", lineNum));
                                continue;
                            }

                            // Check the format of data, and update ImportResult accordingly.
                            int movieID = 0;
                            if (!int.TryParse(columns[0].Trim(), out movieID))
                            {
                                results.FailedRows++;
                                results.ErrorMessages.Add(string.Format("Line {0}: MovieID is not a number.", lineNum));
                                continue;
                            }
                            string title = columns[1].Trim();
                            if (title == "")
                            {
                                results.FailedRows++;
                                results.ErrorMessages.Add(string.Format("Line {0} is empty", lineNum));
                                continue;
                            }


                            // Insert/update DB if okay.
                            Movie movieToUpdate = movies.Where(m => m.MovieID == movieID).FirstOrDefault();
                            if (movieToUpdate == null)
                            {
                                Movie movieToAdd = new Movie() { MovieID = movieID, Title = title };
                                DataLayer.DataLayer.AddMovie(movieToAdd);
                            }
                            else
                            {
                                movieToUpdate.Title = title;
                                DataLayer.DataLayer.UpdateMovie(movieToUpdate);
                            }
                        results.ImportedRows++;                        


                        }
                    catch (System.Data.Common.DbException dbEx)
                    {
                        results.FailedRows++;
                        results.ErrorMessages.Add(string.Format("Line {0}: Database error occurred updating data.", lineNum));
                    }
                    finally
                        {
                            lineNum++;
                        }


                    }


                

            }
            catch(IOException ioe)
            {
                results.ErrorMessages.Add("IO Exception occurred");
            }
            catch(Exception e)
            {
                results.ErrorMessages.Add("Unknown Exception occurred");
            }
            finally
            {
                RaiseCompleted(results);
            }
        }
        }
    }

