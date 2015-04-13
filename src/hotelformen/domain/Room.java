/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelformen.domain;

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
    
    public Room(int id, RoomType type, String phoneNR, double price)
    {
        ID = id;
        _type = type;
        _phoneNR = phoneNR;
        _price = price;
    }
    
    public RoomType getType() {return _type; }
    public void setType(RoomType type) {_type = type; }
    
    public int getID() {return ID; }
    
    public String getPhoneNR() {return _phoneNR; }
    public void setPhoneNR(String phoneNR) { _phoneNR = phoneNR; }

    public double getPrice() { return _price; }
    public void setPrice(double _price) { this._price = _price; }
}
