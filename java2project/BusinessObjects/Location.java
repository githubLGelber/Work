
package java2project.BusinessObjects;

public class Location {
    private String city;
    public String getCity()
    {
        return city;
    }
    public void setCity(String city)
    {
        this.city=city;
    }
    private String airportCode;
    public String getAirportCode()
    {
        return airportCode;
    }
    public void setAirportCode(String airportCode)
    {
        this.airportCode=airportCode;
    }
    
    public String toString()
    {
        return city+" "+airportCode;
    }
}
