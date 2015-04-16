package hotelformen;

import hotelformen.domain.*;
import hotelformen.ui.gui.MainMenu;
import javax.swing.JFrame;
import hotelformen.technical.DatabaseHandler;
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
        
        DatabaseHandler dbHandler = new DatabaseHandler();
        List<Booking> test = dbHandler.getBookings();

    }
    
}
