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
    private Date startDate, endDate;

    /**
     * @return the startDate
     */
    public Date getStartDate()                  {return startDate;}
    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate)    {this.startDate = startDate;}

    /**
     * @return the endDate
     */
    public Date getEndDate()                    {return endDate;}
    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate)        {this.endDate = endDate;}
}
