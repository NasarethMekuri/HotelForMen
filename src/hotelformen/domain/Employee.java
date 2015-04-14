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
    private String title;
    private double wage;

    /**
     * @return the title
     */
    public String getTitle()            {return title;}
    /**
     * @param title the title to set
     */
    public void setTitle(String title)  {this.title = title;}

    /**
     * @return the wage
     */
    public double getWage()             {return wage;}
    /**
     * @param wage the wage to set
     */
    public void setWage(double wage)    {this.wage = wage;}
    
}
