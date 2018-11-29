
package java2project.BusinessObjects;
import java.util.*;
import java.text.*;
public class Flight {
    private String flightNumber;
    public String getFlightNumber()
    {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber)
    {
        this.flightNumber=flightNumber;
    }
    private String departureAirport;
    public String getDepartureAirport()
    {
        return departureAirport;
    }
    public void setDepartureAirport(String departureAirport)
    {
        this.departureAirport=departureAirport;
    }
    private String destinationAirport;
    public String getDestinationAirport()
    {
        return destinationAirport;
    }
    public void setDestinationAirport(String destinationAirport)
    {
        this.destinationAirport=destinationAirport;
    }
    private double price;
    public double getPrice()
    {
        return price;
    }
    public void setPrice(double price)
    {
        this.price=price;
    }
    private Date DateTime;
    
    public Date getDateTime()
    {
       return DateTime; 
    }
    public void setDateTime(Date DateTime)
    {
      this.DateTime=DateTime;
    }
    private String plane;
    public String getPlane()
    {
      return plane;  
    }
    public void setPlane(String plane)
    {
        this.plane=plane;
    }
    private int seatsTaken;
    public int getSeatsTaken()
    {
        return seatsTaken;
    }
    public void setSeatsTaken(int seatsTaken)
    {
        this.seatsTaken=seatsTaken;
    }
    String pattern="dd/MM/yyyy HH:mm";
    SimpleDateFormat format1=new SimpleDateFormat(pattern);
    public String toString()
    {
        return format1.format(DateTime);
    }
    
}
