package hotelformen.domain;

import java.util.List;

public class Booking
{
    private Customer _customer;
    private List<Service> _services;
    private List<Reservation> _reservations;
    private boolean _isActive;
    private double AccumulatedPrice;

    /**
     * @return the _customer
     */
    public Customer getCustomer()                               {return _customer;}
    /**
     * @param _customer the _customer to set
     */
    public void setCustomer(Customer _customer)                 {this._customer = _customer;}

    /**
     * @return the _services
     */
    public List<Service> getServices()                          {return _services;}
    /**
     * @param _services the _services to set
     */
    public void setServices(List<Service> _services)            {this._services = _services;}

    /**
     * @return the _reservations
     */
    public List<Reservation> getReservations()                  {return _reservations;}
    /**
     * @param _reservations the _reservations to set
     */
    public void setReservations(List<Reservation> _reservations){this._reservations = _reservations;}

    /**
     * @return the _isActive
     */
    public boolean isIsActive()                                 {return _isActive;}
    /**
     * @param _isActive the _isActive to set
     */
    public void setIsActive(boolean _isActive)                  {this._isActive = _isActive;}

    /**
     * @return the AccumulatedPrice
     */
    public double getAccumulatedPrice()                         {return AccumulatedPrice;}
    /**
     * @param AccumulatedPrice the AccumulatedPrice to set
     */
    public void setAccumulatedPrice(double AccumulatedPrice)    {this.AccumulatedPrice = AccumulatedPrice;}
    
}
