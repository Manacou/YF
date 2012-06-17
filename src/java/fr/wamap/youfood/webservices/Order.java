/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.webservices;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Order {
    
    @WebMethod
    public String[] getFinishedOrder()
    {
        String[] list = {"France","Engalnd"};
        
        return list;
    }
}
