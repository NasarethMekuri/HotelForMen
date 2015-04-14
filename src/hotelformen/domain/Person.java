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
    private int _id;
    private String _name, _phoneNR;

    /**
     * @return the _id
     */
    public int getId()                  {return _id;}
    /**
     * @param id the _id to set
     */
    public void setId(int id)           {this._id = id;}

    /**
     * @return the _name
     */
    public String getName()             {return _name;}
    /**
     * @param name the _name to set
     */
    public void setName(String name)    {this._name = name;}
    
    /**
     * @return the _phoneNR
     */
    public String getPhoneNR()              {return _phoneNR;}
    /**
     * @param phoneNR the _phoneNR to set
     */
    public void setPhoneNR(String phoneNR)  {this._phoneNR = phoneNR;}
    
    
}
