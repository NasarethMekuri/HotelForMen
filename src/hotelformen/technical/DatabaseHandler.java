package hotelformen.technical;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.sql.Connection;
import java.sql.SQLException;
import hotelformen.domain.*;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Team Kawabunga
 */
public class DatabaseHandler 
{
    private final String SERVER_NAME = "localhost"; 
    private final String DATABASE_INSTANCE = "MKJ";
    private final int PORTNO = 1433;
    private final String DATABASE_NAME = "HotelForMen";
    private final String USERNAME = "sa";
    private final String PASSWORD = "offlimit";

    private Connection getConnection()  throws SQLException
    {
        SQLServerDataSource ds = new SQLServerDataSource();
        
        ds.setServerName(SERVER_NAME);
        ds.setInstanceName(DATABASE_INSTANCE);
        ds.setDatabaseName(DATABASE_NAME); 
        ds.setPortNumber(PORTNO);
        ds.setUser(USERNAME);
        ds.setPassword(PASSWORD);
        return ds.getConnection();
    }

    public List<Room> getRooms()
    {
        List<Room> rooms = new ArrayList<Room>();
        ResultSet rs = null;
        Connection c = null;
        try
        {
            c = getConnection();
            CallableStatement cs = c.prepareCall("{call get_rooms}");
            rs = cs.executeQuery();
            
            while(rs.next())
            {
                rooms.add(new Room(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }
        } catch (SQLException ex)
        {
            System.out.println("Database Error!");
        }
        finally
        {
            try
            {
                c.close();
            } catch (SQLException ex)
            {
                System.out.println("Failed to close database!");
            }
        }
        return rooms;
    }
    
    public List<Service> getServices()
    {
        List<Service> services = new ArrayList<Service>();
        ResultSet rs = null;
        Connection c = null;
        try
        {
            c = getConnection();
            CallableStatement cs = c.prepareCall("{call get_services}");
            rs = cs.executeQuery();
            
            while(rs.next())
            {
                services.add(new Service(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
            }
        } catch (SQLException ex)
        {
            System.out.println("Database Error!");
        }
        finally
        {
            try
            {
                c.close();
            } catch (SQLException ex)
            {
                System.out.println("Failed to close database!");
            }
        }
        return services;
    }
    
    public List<Reservation> getReservations()
    {
        List<Reservation> reservations = new ArrayList<Reservation>();
        ResultSet rs = null;
        Connection c = null;
        try
        {
            c = getConnection();
            CallableStatement cs = c.prepareCall("{call get_reservations}");
            rs = cs.executeQuery();
            
            while(rs.next())
            {
                reservations.add(new Reservation(rs.getInt(1), rs.getDate(4), rs.getDate(5)));
            }
        } catch (SQLException ex)
        {
            System.out.println("Database Error!");
        }
        finally
        {
            try
            {
                c.close();
            } catch (SQLException ex)
            {
                System.out.println("Failed to close database!");
            }
        }
        return reservations;
    }
    
    public List<Customer> getCustomers()
    {
        List<Customer> customers = new ArrayList<Customer>();
        ResultSet rs = null;
        Connection c = null;
        try
        {
            c = getConnection();
            CallableStatement cs = c.prepareCall("{call get_customers}");
            rs = cs.executeQuery();
            
            while(rs.next())
            {
                customers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (SQLException ex)
        {
            System.out.println("Database Error!");
        }
        finally
        {
            try
            {
                c.close();
            } catch (SQLException ex)
            {
                System.out.println("Failed to close database!");
            }
        }
        return customers;
    }
    
     public List<Employee> getEmployees()
    {
        List<Employee> employees = new ArrayList<Employee>();
        ResultSet rs = null;
        Connection c = null;
        try
        {
            c = getConnection();
            CallableStatement cs = c.prepareCall("{call get_employees}");
            rs = cs.executeQuery();
            
            while(rs.next())
            {
                employees.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getInt(6)));
            }
        } catch (SQLException ex)
        {
            System.out.println("Database Error!");
        }
        finally
        {
            try
            {
                c.close();
            } catch (SQLException ex)
            {
                System.out.println("Failed to close database!");
            }
        }
        return employees;
    }
    
    
    public List<Booking> getBookings()
    {
        List<Booking> bookings = new ArrayList<Booking>();
        ResultSet rs = null;
        Connection c = null;
        try
        {
            c = getConnection();
            
            //Get bookings, that contains the IDs we need to create the Booking objects.
            CallableStatement cs = c.prepareCall("{call get_bookings}");
            rs = cs.executeQuery();

            while(rs.next())
            {
                //Get info from booking.
                int bookingID = rs.getInt(1);
                int empID = rs.getInt(2); //Currently not used in the Booking Object.
                int customerID = rs.getInt(3);
                //Get customer for the booking.
                cs = c.prepareCall("{call get_customer_from_booking(?)}");
                cs.setInt(1, customerID);
                ResultSet tmpRS = cs.executeQuery();
                Customer cust = null;
                while (tmpRS.next())
                    cust = new Customer(tmpRS.getInt(1), tmpRS.getString(2), tmpRS.getString(3), tmpRS.getString(4), tmpRS.getInt(5));
                
                //Get services for the booking.
                cs = c.prepareCall("{call get_services_from_booking(?)}");
                cs.setInt(1, bookingID);
                List<Service> services = new ArrayList<Service>();
                tmpRS = cs.executeQuery();
                while(tmpRS.next())
                    services.add(new Service(tmpRS.getInt(1), tmpRS.getString(2), tmpRS.getString(3), tmpRS.getDouble(4)));
                
                //Get reservations for the booking.
                cs = c.prepareCall("{call get_reservations_from_booking(?)}");
                cs.setInt(1,bookingID);
                List<Reservation> reservations = new ArrayList<Reservation>();
                tmpRS = cs.executeQuery();
                while(tmpRS.next())
                    reservations.add(new Reservation(tmpRS.getInt(1), tmpRS.getDate(4), tmpRS.getDate(5)));
                //Create a Booking.
                bookings.add(new Booking(cust, services, reservations));
            }
        } catch (SQLException ex)
        {
            System.out.println("Database Error! - " + ex.getLocalizedMessage());
        }
        finally
        {
            try
            {
                c.close();
            } catch (SQLException ex)
            {
                System.out.println("Failed to close database!");
            }
        }
        return bookings;
    }
    
    public boolean saveBooking(Booking booking)
    {
        Connection c = null;
        boolean success = true;
        try
        {
            c = getConnection();
            CallableStatement cs = c.prepareCall("{call add_booking(?, ?, ?)}");
            cs.setInt(1, 1); //Currently booking does not have an employee attached. Hardcoded value used.
            cs.setInt(2, booking.getCustomer().getId());
            cs.registerOutParameter(3, java.sql.Types.INTEGER);
            
            cs.execute();
            int bookingID = cs.getInt(3);
            
            for(Service s : booking.getServices())
            {
                cs = c.prepareCall("{call add_booked_service(?, ?)}");
                cs.setInt(1, s.getID());
                cs.setInt(2, bookingID);
                cs.execute();
            }
            
            for(Reservation r : booking.getReservations())
            {
                cs = c.prepareCall("{call add_reservation(?, ?, ?, ?)}");
                cs.setInt(1, bookingID);
                cs.setInt(2, r.getRoomID());
                cs.setDate(3, r.getStartDate());
                cs.setDate(4, r.getEndDate());
                cs.execute();
            }
            
        } catch (SQLException ex)
        {
            System.out.println("Database Error! - " + ex.getLocalizedMessage());
            success = false;
        }
        finally
        {
            try
            {
                c.close();
            } catch (SQLException ex)
            {
                System.out.println("Failed to close database!");
            }
        }
        return success;
    }
}
