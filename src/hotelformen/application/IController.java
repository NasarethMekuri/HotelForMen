/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelformen.application;

import hotelformen.domain.Room;
import hotelformen.domain.Service;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author Simon
 */
public interface IController
{
    //Add to BookingManager and convert to IRoomController -When it exists
    public boolean bookRooms(List<Room> rooms, Date startDate, Date endDate, int customerID, List<Service> services);
    public List<Room> getAvailableRooms(Date startDate, Date endDate, String type);
    //Add to ServiceManager and convert to IServiceController -When it exists
    public boolean addServicesToBooking(List<Service> services, int customerID);
    public Service getServiceFromName(String name);
    public Service createService(int id, String name, String description, double price);
    public void updateService(int id, String name, String description, double price);
    public void deleteService(int id);
    public List<Service> getServices();
    //Add to RoomManager and convert to IRoomController -When it exists
    public Room getRoomFromId(int roomID);
    
}
