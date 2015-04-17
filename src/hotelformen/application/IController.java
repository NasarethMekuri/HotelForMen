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
    public boolean bookRooms(List<Room> rooms, Date startDate, Date endDate, int customerID, List<Service> services);
    public boolean addServicesToBooking(List<Service> services, int customerID);
    public Service createService(int id, String name, String description, double price);
    public void updateService(int id, String name, String description, double price);
    public void deleteService(int id);
    public List<Room> getAvailableRooms(Date startDate, Date endDate, String type);
    public List<Service> getServices();
    public Room getRoomFromId(int roomID);
    public Service getServiceFromName(String name);
}
