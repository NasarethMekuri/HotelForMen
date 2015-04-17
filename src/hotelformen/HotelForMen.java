package hotelformen;

import hotelformen.domain.*;
import hotelformen.ui.gui.MainMenu;
import javax.swing.JFrame;
import hotelformen.technical.DatabaseHandler;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class HotelForMen
{
    public static void main(String[] args)
    {
        JFrame mainMenu = new MainMenu();
        
        mainMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainMenu.setResizable(false);
        mainMenu.setTitle("Main Menu");
        mainMenu.setVisible(true);
        mainMenu.setLocationRelativeTo(null);
        
        /*DatabaseHandler dbHandler = new DatabaseHandler();
        List<Customer> customers = dbHandler.getCustomers();
        List<Service> services = dbHandler.getServices();
        List<Reservation> reservations = new ArrayList<Reservation>();
        reservations.add(new Reservation(1, new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 5000000)));
        
        dbHandler.saveBooking(new Booking(customers.get(1), services, reservations));*/

    }
    
}
