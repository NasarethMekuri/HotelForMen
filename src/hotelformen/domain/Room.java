/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelformen.domain;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author bruger
 */
public class Room
{
    private RoomType _type;
    private final int ID;
    private String _phoneNR;
    private double _price;
    private List<Reservation> _reservations;
    
    public Room(int id, String type, String phoneNR, double price)
    {
        ID = id;
        _phoneNR = phoneNR;
        _price = price;
        /*
        
        */
        switch (type.toUpperCase())
        {
            case "SINGLE":
                _type = RoomType.SINGLE;
            break;
            case "DOUBLE":
                _type = RoomType.DOUBLE;
            break;
            case "QUEEN":
                _type = RoomType.QUEEN;
            break;
            case "KING":
                _type = RoomType.KING;
            break;
            case "SHEIK":
                _type = RoomType.SHEIK;
            break;
            case "FOR_MEN":
                _type = RoomType.FOR_MEN;
            break;
                
            default:
                throw new AssertionError("Wrong type"); //TODO-> Handle this is UI
        }
       
    }
    
    public RoomType getType() {return _type; }
    public void setType(RoomType type) {_type = type; }
    
    public int getID() {return ID; }
    
    public String getPhoneNR() {return _phoneNR; }
    public void setPhoneNR(String phoneNR) { _phoneNR = phoneNR; }

    public double getPrice() { return _price; }
    public void setPrice(double _price) { this._price = _price; }
    
    public List<Reservation> getReservations()                      {return _reservations;}
    public void setReservations(List<Reservation> _reservations)    {this._reservations = _reservations;}
    
    
    public Reservation reserveRoom(Date startDate, Date endDate)
    {
        Reservation res = new Reservation(ID, startDate, endDate);
        
        _reservations.add(res);
        
        return res;
    }
    
}
