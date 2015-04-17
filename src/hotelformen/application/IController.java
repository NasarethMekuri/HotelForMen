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
    public void bookRooms(List<Room> rooms, Date startDate, Date endDate, int customerID, List<Service> services);
    public void addServicesToBooking(List<Service> services, int customerID);
    public void createService(int id, String name, String description, double price);
    public void updateService(int id, String name, String description, double price);
    public void deleteService(int id);
    public void getAvailableRooms(Date startDate, Date endDate, String type);
    public void getServices();
}
