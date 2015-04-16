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
    public void bookRooms(List<Room> rooms, Date startDate, Date endDate, Customer customer, List<Service> services)
    {
        hotel.bookRooms(rooms, startDate, endDate, customer, services);
    }

    @Override
    public void addServicesToBooking(List<Service> services, Customer customer)
    {
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
    public void getAvailableRooms(Date startDate, Date endDate, RoomType type)
    {
        hotel.getAvailableRooms(startDate, endDate, type);
    }

    @Override
    public void getServices()
    {
        hotel.getServices();
    }
    
}
