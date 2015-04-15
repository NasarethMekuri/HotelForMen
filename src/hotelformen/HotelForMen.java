package hotelformen;

import hotelformen.ui.gui.MainMenu;
import javax.swing.JFrame;

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
    }
    
}
