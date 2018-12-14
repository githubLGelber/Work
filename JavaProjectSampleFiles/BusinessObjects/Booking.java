
package java2project.BusinessObjects;

public class Booking {
    private int bookingNumber;
    public int getBookingNumber()
    {
        return bookingNumber;
    }
    public void setBookingNumber(int bookingNumber)
    {
        this.bookingNumber=bookingNumber;
    }
    private String flightNumber;
    public String getFlightNumber()
    {
        return flightNumber;
    }
    public void setFlightNumber(String flightNumber)
    {
        this.flightNumber=flightNumber;
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
    private String cabinClass;
    public String getCabinClass()
    {
      return cabinClass;
    }
    public void setCabinClass(String cabinClass)
    {
        this.cabinClass=cabinClass;
    }
    private int quantity;
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity)
    {
        this.quantity=quantity;
    }
    private boolean insurance;
    public boolean getInsurance()
    {
        return insurance;
    }
    public void setInsurance(boolean insurance)
    {
      this.insurance=insurance;   
    }
}
