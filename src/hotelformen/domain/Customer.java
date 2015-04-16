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
public class Customer extends Person
{
    private String _paymentInfo;

    public Customer(int id, String name, String paymentInfo, String phoneNR, int postalNR)
    {
        super(id, name, phoneNR);
        _paymentInfo = paymentInfo;
    }
    /**
     * @return the _paymentInfo
     */
    public String getPaymentInfo()                  {return _paymentInfo;}
    /**
     * @param _paymentInfo the _paymentInfo to set
     */
    public void setPaymentInfo(String _paymentInfo) {this._paymentInfo = _paymentInfo;}
    
 
    
    
}
