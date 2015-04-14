/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelformen.domain;

/**
 *
 * @author Simon
 */
public class Employee extends Person
{
    private String _title;
    private double _wage;

    /**
     * @return the _title
     */
    public String getTitle()            {return _title;}
    /**
     * @param title the _title to set
     */
    public void setTitle(String title)  {this._title = title;}

    /**
     * @return the _wage
     */
    public double getWage()             {return _wage;}
    /**
     * @param wage the _wage to set
     */
    public void setWage(double wage)    {this._wage = wage;}
    
}
