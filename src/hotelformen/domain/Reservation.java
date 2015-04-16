/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelformen.domain;

import java.sql.Date;

/**
 *
 * @author Simon
 */
public class Reservation
{
    private Date _startDate, _endDate;
    private int _roomID;
    
    public Reservation(int roomID, Date startDate, Date endDate)
    {
        setRoomID(roomID);
        setStartDate(startDate);
        setEndDate(endDate);
    }

    /**
     * @return the _startDate
     */
    public Date getStartDate()                  {return _startDate;}
    /**
     * @param startDate the _startDate to set
     */
    public void setStartDate(Date startDate)    {this._startDate = startDate;}

    /**
     * @return the _endDate
     */
    public Date getEndDate()                    {return _endDate;}
    /**
     * @param endDate the _endDate to set
     */
    public void setEndDate(Date endDate)        {this._endDate = endDate;}

    /**
     * @return the _roomID
     */
    public int getRoomID()                      {return _roomID;}
    /**
     * @param _roomID the _roomID to set
     */
    public void setRoomID(int _roomID)          {this._roomID = _roomID;}

   
}
