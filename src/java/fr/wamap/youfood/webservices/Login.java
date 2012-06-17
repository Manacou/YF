/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.webservices;

import fr.wamap.youfood.daos.UserDao;
import fr.wamap.youfood.entities.User;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Login {
    
    @EJB
    private UserDao userDao;
    @WebMethod
    public String Login(@WebParam(name="login") String login, @WebParam(name="pwd") String password)
    {
        User user = userDao.getUserByLogin(login);
        
        if (user != null)
        {
            if(user.getPassword().equals(password))
            {
                return "true";
            }
            else
            {
                return "false";
            }
        }
        else
        {
            return "false";
        }
    }
    
}
