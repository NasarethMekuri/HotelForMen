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
    public void getAvailableRooms(Date startDate, Date endDate, String type)
    {
        RoomType _type = getTypeFromString(type);
        hotel.getAvailableRooms(startDate, endDate, _type);
    }
    
    @Override
    public void bookRooms(List<Room> rooms, Date startDate, Date endDate, int customerID, List<Service> services)
    {
        Customer customer = getCustomerFromId(customerID);
        hotel.bookRooms(rooms, startDate, endDate, customer, services);
    }

    @Override
    public void addServicesToBooking(List<Service> services, int customerID)
    {
        Customer customer = getCustomerFromId(customerID);
        hotel.addServicesToBooking(services, customer);
    }

    @Override
    public void createService(int id, String name, String description, double price)
    {
        hotel.createService(id, name, description, price);
    }

    @Override
    public void updateService(int id, String name, String description, double price)
    {
        hotel.updateService(id, name, description, price);
    }

    @Override
    public void deleteService(int id)
    {
        hotel.deleteService(id);
    }

    
    @Override
    public void getServices()
    {
        hotel.getServices();
    }
    
    private RoomType getTypeFromString(String _type)
    {
            switch (_type.toUpperCase())
        {
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
