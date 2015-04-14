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
public abstract class Person
{
    private int id;
    private String name, phoneNR;

    /**
     * @return the id
     */
    public int getId()                  {return id;}
    /**
     * @param id the id to set
     */
    public void setId(int id)           {this.id = id;}

    /**
     * @return the name
     */
    public String getName()             {return name;}
    /**
     * @param name the name to set
     */
    public void setName(String name)    {this.name = name;}
    
    /**
     * @return the phoneNR
     */
    public String getPhoneNR()              {return phoneNR;}
    /**
     * @param phoneNR the phoneNR to set
     */
    public void setPhoneNR(String phoneNR)  {this.phoneNR = phoneNR;}
    
    
}
