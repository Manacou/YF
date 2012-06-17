/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.webservices;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Menu {
    
    @WebMethod
    public String sayHello(@WebParam(name="str")String r)
    {
        return r;
    }
}
