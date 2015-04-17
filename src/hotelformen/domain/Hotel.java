package hotelformen.domain;

import hotelformen.technical.DatabaseHandler;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Hotel
{
    private List<Room> _rooms;
    private List<Customer> _customers;
    private List<Employee> _employees;
    private List<Service> _services;
    private List<Booking> _bookings;
    private DatabaseHandler _databaseHandler;
    
    public Hotel()
    {
       _databaseHandler = new DatabaseHandler();
       _rooms = _databaseHandler.getRooms();
       _customers = _databaseHandler.getCustomers();
       _employees = _databaseHandler.getEmployees();
       _services = _databaseHandler.getServices();
       _bookings = _databaseHandler.getBookings();
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
     * @return the _bookings
     */
    public List<Booking> getBookings()                  {return _bookings;}
    /**
     * @param _bookings the _bookings to set
     */
    public void setBookings(List<Booking> _bookings)    {this._bookings = _bookings;}
    
      /**
     * @return the _dbh
     */
    public DatabaseHandler getDatabaseHandler()                     {return _databaseHandler;}
    
    /**
     * This method creates a Room
     * @param id the Room ID
     * @param type the room type
     * @param phoneNR the Rooms phoneNumber
     * @param price The cost of the Room
     * @return
     */
    public Room createRoom(int id, String type, String phoneNR, double price)
    {
        return new Room(id, type, phoneNR, price);
    }
    
    /*
    TODO: updateRoom and deleteRoom methods. (Get them from list? or give Room as param?, or overload?)
    */
    
    /**
     *
     * This method searches all the rooms in the hotel and their reservations for availability.
     * If a reservation has not been made, or partially made within the requested (param) timeframe, the Room will be added to the List that is returned.
     * @param startDate the StartDate of the requested reservation
     * @param endDate the EndDate of the requested reservation
     * @param type the Roomtype, if a customer has a request for a Room of a specific type. (Can be Null if there are not any preferences from the customer)
     * @return Returns a list of Avilable rooms, within the given parameters.
     */
    
    
    public List<Room> getAvailableRooms(Date startDate, Date endDate, RoomType type)
    {
        List<Room> result = new ArrayList<Room>();
        
        //Iterate through the List of Rooms.
        for (int i = 0; i < _rooms.size(); i++)
        {
            //Check the roomtype for null, AND if roomtype is the same as the roomtype of the Room in the current iteration.
            if (type != null && type != _rooms.get(i).getType())
            {
                continue;
            }
            //Get all reservations for the Room in the current iteration.
            List<Reservation> roomReservations = _rooms.get(i).getReservations();
            
            //Iterate through the reservations of the Room in the current iteration.
            for (int j = 0; j < roomReservations.size(); j++)
            {
                //Check if (param)startDate is before the startDate in the reservation AND if (param)startDate is after the EndDate in the reservation.
                if (roomReservations.get(j).getStartDate().compareTo(startDate) < 0 && roomReservations.get(j).getEndDate().compareTo(startDate) > 0)
                {
                    //Check if (param)endDate is before the startDate in the reservation AND if (param)endDate is after the EndDate in the reservation.
                    if (roomReservations.get(j).getStartDate().compareTo(endDate) < 0 && roomReservations.get(j).getEndDate().compareTo(endDate) > 0)
                    {
                        //Check if (param)startDate is before the startDate in the reservation AND if (param)endDate is before the startDate in the reservation.
                        if (roomReservations.get(j).getStartDate().compareTo(startDate) < 0 && roomReservations.get(j).getStartDate().compareTo(endDate) < 0)
                        {
                            //if above is true, add to result-List
                            result.add(_rooms.get(i));
                        }
                        //Check if (param)startDate is after the endDate in the reservation AND if (param)endDate is after the endDate in the reservation.
                        else if (roomReservations.get(j).getEndDate().compareTo(startDate) > 0 && roomReservations.get(j).getEndDate().compareTo(endDate) > 0)
                        {
                            //if above is true, add to result-List
                            result.add(_rooms.get(i));
                        }
                    }
                }
            }
        }
        return result;
    }
    
  
    public boolean bookRooms(List<Room> rooms, Date startDate, Date endDate, Customer customer, List<Service> services)
    {
        List<Reservation> reservationsList = new ArrayList<Reservation>();
        
        for (int i = 0; i < rooms.size(); i++)
        {
            reservationsList.add(rooms.get(i).reserveRoom(startDate, endDate));
        }
        
        return createBooking(reservationsList, customer, services);
    }
    
    public List<Service> viewAvailableServices()
    {
        return _services;
    }
    
    public boolean addServicesToBooking(List<Service> services, Customer customer)
    {   
        //TODO#1: Cannot return false is Customer does not have an active booking.
        //TODO#2: Service(s) are added to all of the customer's active bookings.
        for (int i = 0; i < _bookings.size(); i++)
        {
            if (_bookings.get(i).getCustomer().getId() == customer.getId() && _bookings.get(i).isActive())
            {
                for (Service s : services)
                {
                    _bookings.get(i).addServiceToBooking(s);
                    //TODO SAVE DATA TO DATABASE.
                    //return here to only add service(s) to customers FIRST occuring booking
                }   
            }
        }
        return true;
    }
    
    
    private boolean createBooking(List<Reservation> reservations, Customer customer, List<Service> services)
    {
        Booking booking = new Booking(customer, services, reservations);
        
        return _databaseHandler.saveBooking(booking);
    }
    
    
    //Manage Services:
    public Service createService(int id, String name, String description, double price)
    {
        //TODO: Handle ID! (ID should be unique, so It cannot be given as param) 
        //Create Service in Database - and fetch the unique ID from the Service table.
        return new Service(id, name, description, price);
    }
    
    public void updateService(int id, String name, String description, double price)//TODO: return type must be boolean! change should be verified 
    {
        for (int i = 0; i < _services.size(); i++)
        {
            if (_services.get(i).getID() == id)
            {
                _services.get(i).setName(name);
                _services.get(i).setDescripion(description);
                _services.get(i).setPrice(price);
                return;
            }
        }
    }
    
    public void updateServiceName(int id, String name)//TODO: return type must be boolean! change should be verified 
    {
        for (Service s : _services)
        {
            if (s.getID() == id)
            {
                s.setName(name);
                return;
            }
        }
    }
    
    public void updateServiceDescription(int id, String description)//TODO: return type must be boolean! change should be verified 
    {
        for (Service s : _services)
        {
            if (s.getID() == id)
            {
                s.setDescripion(description);
                return;
            }
        }
    }
    
    public void updateServicePrice(int id, double price)//TODO: return type must be boolean! change should be verified 
    {
        for (Service s : _services)
        {
            if (s.getID() == id)
            {
                s.setPrice(price);
                return;
            }
        }
    }
    
    public void deleteService(int id) //TODO: return type must be boolean! change should be verified 
    {
        for (int i = 0; i < _services.size(); i++)
        {
            if (_services.get(i).getID() == id)
            {
               _services.remove(i);
               return;
            }
        }
    }

  
}


