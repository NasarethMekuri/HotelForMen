package hotelformen.domain;

import java.util.List;

public class Hotel
{
    private List<Room> _rooms;
    private List<Customer> _customers;
    private List<Employee> _employees;
    private List<Service> _services;

    public Hotel()
    {
        /*
        TODO:
        Initialize all variables from Database?
        */
    }
    
    /**
     * @return the _rooms
     */
    public List<Room> getRooms()                        {return _rooms;}
    /**
     * @param _rooms the _rooms to set
     */
    public void setRooms(List<Room> _rooms)             {this._rooms = _rooms;}

    /**
     * @return the _customers
     */
    public List<Customer> getCustomers()                {return _customers;}
    /**
     * @param _customers the _customers to set
     */
    public void setCustomers(List<Customer> _customers) {this._customers = _customers;}

    /**
     * @return the _employees
     */
    public List<Employee> getEmployees()                {return _employees;}
    /**
     * @param _employees the _employees to set
     */
    public void setEmployees(List<Employee> _employees) {this._employees = _employees;}

    /**
     * @return the _services
     */
    public List<Service> getServices()                  {return _services;}
    /**
     * @param _services the _services to set
     */
    public void setServices(List<Service> _services)    {this._services = _services;}
    
    /**
     * This method creates a Room
     * @param id the Room ID
     * @param type the room type
     * @param phoneNR the Rooms phoneNumber
     * @param price The cost of the Room
     * @return 
     */
    public Room createRoom(int id, RoomType type, String phoneNR, double price)
    {
        return new Room(id, type, phoneNR, price);
    }
    
    /*
    TODO: updateRoom and deleteRoom methods. (Get them from list? or give Room as param?, or overload?)
    */
    
    
}
