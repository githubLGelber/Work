
package java2project;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class LocationImporter extends BaseImporter {
    Booking1 b1=new Booking1();
    ArrayList<String> x3=new ArrayList<>();
    ImportResult IRobj;
    public LocationImporter(String fileName)
    {
        super(fileName);
    }
    public void run()
    {
       IRobj=new ImportResult();
       setResult(IRobj);
       String fileData="";
       try(FileReader inputFile=new FileReader(fileName))
       {
           int ch=0;
           while((ch=inputFile.read())!=-1)
           {
               fileData+=fileData+ch;
           }
           String[] lines=fileData.replace("\r\n","\n").replace("\r","\n").split("\n");
           String firstLine=lines[0];
           String[] columns=firstLine.split(",");
           if(columns.length==2)
           {
               if(columns[0].equals("City")&&columns[1].equals("AirportCode"))
               {
                   String[] lines2=new String[lines.length-1];
                   for(int i=0;i<lines.length-1;i++)
                   {
                       lines2[i]=lines[i];
                   }   
                   int lineNum=1;
                   for(String line:lines2)
                   {
                       try
                       {
                           if(line.equals(""))
                           {
                               continue;
                           }
                           else
                           {
                               int x=IRobj.getTotalRows();
                               x++;
                               IRobj.setTotalRows(x);
                               columns=line.split(",");
                               if(columns[0].equals(""))
                               {
                                  int x2=IRobj.getFailedRows();
                                  x2++;
                                  IRobj.setFailedRows(x2);
                                  x3.add("Error occurred on line"+lineNum);
                               }
                               else if(columns[1].equals(""))
                               {
                                  int x2=IRobj.getFailedRows();
                                  x2++;
                                  IRobj.setFailedRows(x2);
                                  x3.add("Error occurred on line"+lineNum);
                               }
                               else
                               {
                                Pattern pattern=Pattern.compile("\\b\\w{3}\\b");
                                Matcher matcher=pattern.matcher(columns[1]);
                                if(!matcher.find())
                                {
                                   int x2=IRobj.getFailedRows();
                                   x2++;
                                   IRobj.setFailedRows(x2);
                                   x3.add("Error occurred on line"+lineNum);
                                }
                                java2project.BusinessObjects.Location locationToUpdate=DatabaseOperations1.getLocationByAirportCode(columns[1]);
                                if(locationToUpdate==null)
                                {
                                   java2project.BusinessObjects.Location locationToAdd=new java2project.BusinessObjects.Location();
                                   locationToAdd.setCity(columns[0]);
                                   locationToAdd.setAirportCode(columns[1]);
                                   DatabaseOperations1.AddLocation(locationToAdd);
                                   b1.locationsList.add(locationToAdd);
                                   
                                   int x4=IRobj.getImportedRows();
                                   x4++;
                                   IRobj.setImportedRows(x4);
                                }
                                else
                                {
                                   DatabaseOperations1.UpdateLocation(locationToUpdate);
                                   int x4=IRobj.getImportedRows();
                                   x4++;
                                   IRobj.setImportedRows(x4);
                                }
                               }
                           }
                                  
                       }
                       catch(ArrayIndexOutOfBoundsException e)
                       {
                           int x2=IRobj.getFailedRows();
                           x2++;
                           IRobj.setFailedRows(x2);
                           System.out.println(e.toString());
                           x3.add("Error occurred on line"+lineNum);
                       }
                      
                       finally
                       {
                           lineNum++ ;   
                       }
                   }
               }
           }
           
       }
       catch(IOException ioe)
       {
           x3.add("Error: input/output error");
       }
       catch(Exception e)
       {
           x3.add("Unknown error occurred");
       }
    }
}
