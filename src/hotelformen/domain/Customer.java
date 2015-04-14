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

    /**
     * @return the _paymentInfo
     */
    public String getPaymentInfo()                  {return _paymentInfo;}
    /**
     * @param _paymentInfo the _paymentInfo to set
     */
    public void setPaymentInfo(String _paymentInfo) {this._paymentInfo = _paymentInfo;}
    
 
    
    
}
