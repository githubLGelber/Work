
package java2project;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;

public class FlightImporter extends BaseImporter {
    ImportResult IRobj;
    String pattern1="dd/MM/yyyy HH:mm:ss";
    SimpleDateFormat format1=new SimpleDateFormat(pattern1);
    ArrayList<String> x3=new ArrayList<>();
    
    public FlightImporter(String fileName)
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
           
           
           if(columns.length==7)
           {
               if(columns[0].equals("Flight Number")&&columns[1].equals("Departure Airport")
               &&columns[2].equals("Destination Airport")&&columns[3].equals("Price")
               &&columns[4].equals("DateTime")&&columns[5].equals("Plane")
               &&columns[6].equals("Seats Taken"))
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
                               if(columns.length==7)
                               {
                                  if(columns[0].equals(""))
                                  {
                                   int x2=IRobj.getFailedRows();
                                   x2++;
                                   IRobj.setFailedRows(x2);
                                   x3.add("Error occurred on line"+lineNum);
                                  }
                                  if(columns[1].equals(""))
                                  {
                                   int x2=IRobj.getFailedRows();
                                   x2++;
                                   IRobj.setFailedRows(x2);
                                   x3.add("Error occurred on line"+lineNum);
                                  }
                                  if(columns[2].equals(""))
                                  {
                                   int x2=IRobj.getFailedRows();
                                   x2++;
                                   IRobj.setFailedRows(x2);
                                   x3.add("Error occurred on line"+lineNum);
                                  }
                                  if(columns[5].equals(""))
                                  {
                                   int x2=IRobj.getFailedRows();
                                   x2++;
                                   IRobj.setFailedRows(x2);
                                   x3.add("Error occurred on line"+lineNum);
                                  }
                                  else
                                  {
                                     Pattern pattern=Pattern.compile("\\b\\w{2}\\d{3}\\b");
                                     Matcher matcher=pattern.matcher(columns[0]);
                                     if(!matcher.find())
                                     {
                                      int x2=IRobj.getFailedRows();
                                      x2++;
                                      IRobj.setFailedRows(x2);
                                      x3.add("Error occurred on line"+lineNum);
                                     }
                                     pattern=Pattern.compile("\\b\\w{3}\\b");
                                     matcher=pattern.matcher(columns[1]);
                                     if(!matcher.find())
                                     {
                                      int x2=IRobj.getFailedRows();
                                      x2++;
                                      IRobj.setFailedRows(x2);
                                      x3.add("Error occurred on line"+lineNum);
                                     }
                                     pattern=Pattern.compile("\\b\\w{3}\\b");
                                     matcher=pattern.matcher(columns[2]);
                                     if(!matcher.find())
                                     {
                                      int x2=IRobj.getFailedRows();
                                      x2++;
                                      IRobj.setFailedRows(x2);
                                      x3.add("Error occurred on line"+lineNum);
                                     }
                                      Double y1=Double.parseDouble (columns[3]);
                                      
                                      if(!(y1 instanceof Double))
                                      {
                                         int x2=IRobj.getFailedRows();
                                         x2++;
                                         IRobj.setFailedRows(x2);
                                         x3.add("Error occurred on line"+lineNum); 
                                      }
                                      Integer y2= Integer.parseInt(columns[6]);

                                      if(!(y2 instanceof Integer))
                                      {
                                         int x2=IRobj.getFailedRows();
                                         x2++;
                                         IRobj.setFailedRows(x2);
                                         x3.add("Error occurred on line"+lineNum); 
                                      }
                                      Date date1= new SimpleDateFormat(pattern1).parse(columns[4]);

                                      if(!columns[4].equals(format1.format(date1)))
                                      {
                                         int x2=IRobj.getFailedRows();
                                         x2++;
                                         IRobj.setFailedRows(x2);
                                         x3.add("Error occurred on line"+lineNum); 
                                      }
                                      EnumerationClass.Plane planeType=EnumerationClass.Plane.valueOf(columns[5]);
                                      for(EnumerationClass.Plane types:EnumerationClass.Plane.values())
                                      {
                                          if(planeType==types)
                                          {
                                              planeType=types;
                                          }
                                          else
                                          {
                                               int x2=IRobj.getFailedRows();
                                               x2++;
                                               IRobj.setFailedRows(x2);
                                               x3.add("Error occurred on line"+lineNum); 
                                          }
                                      }
                                      
                                      int seats=Integer.parseInt(columns[6]);
                                      if(seats>planeType.getPassengerCapacity())
                                      {
                                          int x2=IRobj.getFailedRows();
                                          x2++;
                                          IRobj.setFailedRows(x2);
                                          x3.add("Error occurred on line"+lineNum);
                                      }
                                      java2project.BusinessObjects.Flight flightToUpdate=DatabaseOperations1.getFlightByFlightNumber(columns[0]);
                                      if(flightToUpdate==null)
                                      {
                                         java2project.BusinessObjects.Flight flightToAdd=new java2project.BusinessObjects.Flight();
                                         flightToAdd.setFlightNumber(columns[0]);
                                         flightToAdd.setDepartureAirport(columns[1]);
                                         flightToAdd.setDestinationAirport(columns[2]);
                                         flightToAdd.setPrice(Double.parseDouble(columns[3]));
                                         flightToAdd.setDateTime(format1.parse(columns[4]));
                                         flightToAdd.setPlane(columns[5]);
                                         flightToAdd.setSeatsTaken(Integer.parseInt(columns[6]));
                                         DatabaseOperations1.AddFlight(flightToAdd);
                                         int x4=IRobj.getImportedRows();
                                         x4++;
                                         IRobj.setImportedRows(x4);
                                      }
                                      else
                                      {
                                         DatabaseOperations1.UpdateFlight(flightToUpdate);
                                         int x4=IRobj.getImportedRows();
                                         x4++;
                                         IRobj.setImportedRows(x4);  
                                      }
 
                                      
                                   }
                                }
                                   
                             }
                       }
                       catch(Exception e)
                       {
                           System.out.println(e.toString());
                       }
                    }
                }
            }
       }
       catch(IOException ioe)
       {
          ioe.toString();
       }
       catch(Exception e)
       {
           e.toString();
       }
    }
}
