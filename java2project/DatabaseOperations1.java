/*
 * This class contains all the common operations that involve retreiving data from the database, 
 * saving data to the database or updating existing database data 
 * for all three tables (Location, Flight and Booking)
 */
package java2project;

import java.sql.*;
import java.util.*;


public class DatabaseOperations1 {
    private static ArrayList<java2project.BusinessObjects.Location> locArray=new ArrayList<>();
    private static ArrayList<java2project.BusinessObjects.Flight> flightArray=new ArrayList<>();
    private static ArrayList<java2project.BusinessObjects.Flight> flightArray2=new ArrayList<>();
    private static java2project.BusinessObjects.Flight flight;
    private static java2project.BusinessObjects.Booking booking;
    private static java2project.BusinessObjects.Location location;
    
    //method that gets all the information from the Location table
    public static ArrayList<java2project.BusinessObjects.Location> GetAllLocations(){
	try (Connection connection = DbConnector.connectToDatabase();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from location")){
            
            while (resultSet.next()) {
            	location.setCity(resultSet.getString("City"));
            	location.setAirportCode(resultSet.getString("AirportCode"));
                locArray.add(location); 
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        }  
        return locArray;
                
    }
    
    
    // this method returns all the data from the Flight table in the uFly database
    public static ArrayList<java2project.BusinessObjects.Flight> GetAllFlightsForLocation(String departure, String destination){
      try (Connection connection = DbConnector.connectToDatabase();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from flight WHERE DepartureAirport="+departure+"AND DestinationAirport="+destination)){
            
            while (resultSet.next()) {
            	flight.setFlightNumber(resultSet.getString("FlightNumber"));
                flight.setDepartureAirport(resultSet.getString("DepartureAirport"));
                flight.setDestinationAirport(resultSet.getString("DestinationAirport"));
                flight.setPrice(resultSet.getDouble("Price"));
                flight.setDateTime(resultSet.getDate("DateTime"));
                flight.setPlane(resultSet.getString("Plane"));
                flight.setSeatsTaken(resultSet.getInt("SeatsTaken"));
                flightArray.add(flight);
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        }  
        return flightArray;
    }
    
    //this method obtains all the information from the Flight table based on the departure and destination airports as well as travel date
    public static ArrayList<java2project.BusinessObjects.Flight> GetAllFlightsForLocation2(String departure, String destination, java.util.Date travelDate){
           try (Connection connection = DbConnector.connectToDatabase();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from flight WHERE DepartureAirport="+departure+"AND DestinationAirport="+destination
            +"AND DateTime="+ travelDate)){
            
            while (resultSet.next()) {
            	flight.setFlightNumber(resultSet.getString("FlightNumber"));
                flight.setDepartureAirport(resultSet.getString("DepartureAirport"));
                flight.setDestinationAirport(resultSet.getString("DestinationAirport"));
                flight.setPrice(resultSet.getDouble("Price"));
                flight.setDateTime(resultSet.getDate("DateTime"));
                flight.setPlane(resultSet.getString("Plane"));
                flight.setSeatsTaken(resultSet.getInt("SeatsTaken"));
                flightArray2.add(flight);
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        }  
        return flightArray2;
    }
    
    //this method adds booking passed as a parameter to the Booking table in the uFly database
    //note that Booking number is set as an incrementing field, so it doesn't need to be set
    public static void AddBooking(java2project.BusinessObjects.Booking booking){
       try (Connection connection = DbConnector.connectToDatabase();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("SELECT * from booking")){

             resultSet.moveToInsertRow();
             resultSet.updateInt("BookingNumber",booking.getBookingNumber());
             resultSet.updateString("FlightNumber", booking.getFlightNumber());
             resultSet.updateDouble("Price",booking.getPrice());
             resultSet.updateString("CabinClass",booking.getCabinClass());
             resultSet.updateInt("Quantity",booking.getQuantity());
             resultSet.updateBoolean("Insurance",booking.getInsurance());
             resultSet.insertRow();
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        }
    }
    
    //this method obtains the flight based on the flightNumber parameter
    public static java2project.BusinessObjects.Flight getFlightByFlightNumber(String flightNumber){
       try (Connection connection = DbConnector.connectToDatabase();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from flight WHERE FlightNumber=" +flightNumber)){
            while (resultSet.next()) {
            	flight.setFlightNumber(resultSet.getString("FlightNumber"));
                flight.setDepartureAirport(resultSet.getString("DepartureAirport"));
                flight.setDestinationAirport(resultSet.getString("DestinationAirport"));
                flight.setPrice(resultSet.getDouble("Price"));
                flight.setDateTime(resultSet.getDate("DateTime"));
                flight.setPlane(resultSet.getString("Plane"));
                flight.setSeatsTaken(resultSet.getInt("SeatsTaken"));
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        }  
       return flight;
    }
    
   public static java2project.BusinessObjects.Location getLocationByAirportCode(String airportCode){
	try (Connection connection = DbConnector.connectToDatabase();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from location "
                    + "WHERE AirportCode = '" + airportCode + "'")){
            
            while (resultSet.next()) {
            	location.setCity(resultSet.getString("City"));
            	location.setAirportCode(resultSet.getString("AirportCode"));
            }
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        }  
        return location;
    }
    
    //this method adds location passed as a parameter to the Location table in the uFly database
    public static void AddLocation(java2project.BusinessObjects.Location location){
	try (Connection connection = DbConnector.connectToDatabase();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("SELECT City, AirportCode from location")){
            
            resultSet.moveToInsertRow();
            resultSet.updateString("City", location.getCity());
            resultSet.updateString("AirportCode", location.getAirportCode());
            resultSet.insertRow();
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        } 
    }
     
    //this method adds a flight passed as a parameter to the Flight table in the uFly database
    public static void AddFlight(java2project.BusinessObjects.Flight flight){
      try (Connection connection = DbConnector.connectToDatabase();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("SELECT * from flight")){

             resultSet.moveToInsertRow();
             resultSet.updateString("FlightNumber", flight.getFlightNumber());
             resultSet.updateString("DepartureAirport", flight.getDepartureAirport());
             resultSet.updateString("DestinationAirport",flight.getDestinationAirport());
             resultSet.updateDouble("Price",flight.getPrice());
             java.util.Date date1=flight.getDateTime();
             String date2=String.valueOf(date1);
             java.sql.Date date3=java.sql.Date.valueOf(date2);
             resultSet.updateDate("DateTime",date3);
             resultSet.updateString("Plane",flight.getPlane());
             resultSet.updateInt("SeatsTaken",flight.getSeatsTaken());
             resultSet.insertRow();
        }
        catch(SQLException sqle){
            System.out.println(sqle.toString());
        }
    }

    
    //this method updates the location to the one passed to it as a parameter where the airport codes are matching
    public static void UpdateLocation(java2project.BusinessObjects.Location location){
        try (Connection connection = DbConnector.connectToDatabase();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("SELECT * from location WHERE" 
             +"AirportCode="+location.getAirportCode()))
        {         
            
            resultSet.absolute(1);
            resultSet.updateString("City",location.getCity());
            resultSet.updateString("AirportCode",location.getAirportCode());
            resultSet.updateRow();
        }
        catch(SQLException sqle)
        {
           System.out.println(sqle.toString());
        }
    }
    
    //this method updates the flight to the one passed to it as a parameter where the flight numbers are matching
    public static void UpdateFlight(java2project.BusinessObjects.Flight flight){
         try (Connection connection = DbConnector.connectToDatabase();
             Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
             ResultSet resultSet = statement.executeQuery("SELECT * from flight WHERE FlightNumber="+flight.getFlightNumber()))
             
        {         
            
            resultSet.absolute(1);
            resultSet.updateString("FlightNumber",flight.getFlightNumber());
            resultSet.updateString("DepartureAirport",flight.getDepartureAirport());
            resultSet.updateString("DestinationAirport",flight.getDestinationAirport());
            resultSet.updateDouble("Price",flight.getPrice());
            java.util.Date date1=flight.getDateTime();
            String date2=String.valueOf(date1);
            java.sql.Date date3=java.sql.Date.valueOf(date2);
            resultSet.updateDate("DateTime",date3);
            resultSet.updateString("Plane",flight.getPlane());
            resultSet.updateInt("SeatsTaken",flight.getSeatsTaken());
            resultSet.updateRow();
        }
        catch(SQLException sqle)
        {
           System.out.println(sqle.toString());
        }
    }
}
