/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package hotelformen.application;

import hotelformen.domain.*;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Simon
 */
public class Controller implements IController
{
    private Hotel hotel = new Hotel();
    
    @Override
    public boolean bookRooms(List<Room> rooms, Date startDate, Date endDate, int customerID, List<Service> services)
    {
        Customer customer = getCustomerFromId(customerID);
        return hotel.bookRooms(rooms, startDate, endDate, customer, services);
    }
    
    @Override
    public List<Room> getAvailableRooms(Date startDate, Date endDate, String type)
    {
        RoomType _type = getTypeFromString(type);
        return hotel.getAvailableRooms(startDate, endDate, _type);
    }
    
    @Override
    public boolean addServicesToBooking(List<Service> services, int customerID)
    {
        Customer customer = getCustomerFromId(customerID);
        return hotel.addServicesToBooking(services, customer);
    }
    
    @Override
    public Service getServiceFromName(String name)
    {
        return hotel.getServiceFromName(name);
    }
    
    @Override
    public Service createService(String name, String description, double price)
    {
        return hotel.createService(name, description, price);
    }
    
    @Override
    public boolean updateService(int id, String name, String description, double price)
    {
        return hotel.updateService(id, name, description, price);
    }
    
    @Override
    public boolean deleteService(int id)
    {
        return hotel.deleteService(id);
    }
    
    @Override
    public List<Service> getServices()
    {
        return hotel.getServices();
    }
    
    @Override
    public Room getRoomFromId(int roomID)
    {
        for (Room r : hotel.getRooms())
        {
            if (r.getID() == roomID)
            {
                return r;
            }
        }
        return null;
    }
    
    private RoomType getTypeFromString(String type)
    {
        switch (type.toUpperCase())
        {
            case "":
                return null;
                
            case "SINGLE":
                return RoomType.SINGLE;
                
            case "DOUBLE":
                return RoomType.DOUBLE;
                
            case "QUEEN":
                return RoomType.QUEEN;
                
            case "KING":
                return RoomType.KING;
                
            case "SHEIK":
                return RoomType.SHEIK;
                
            case "FOR_MEN":
                return RoomType.FOR_MEN;
                
            default:
                throw new AssertionError("Wrong type"); //TODO-> Handle this in UI
        }
    }
    
    private Customer getCustomerFromId(int custID)
    {
        for (Customer c : hotel.getCustomers())
        {
            if (c.getId() == custID)
            {
                return c;
            }
        }
        return null;
    }
    
}
