/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.UserDao;
import fr.wamap.youfood.entities.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserService {
    
    @EJB
    UserDao ud;
    
    public void createUser(User user)
    {
        ud.createUser(user);
    }
    
    public User getUserById(Long id)
    {
        return ud.getUserById(id);
    }
    
    public User getUserByLogin(String login)
    {
        return ud.getUserByLogin(login);
    }
 
    public List<User> getAllUsers()
    {
        return ud.getAllUsers();
    }
    
    public void updateUser(User user)
    {
        ud.updateUser(user);
    }
    
    public void deleteUser(User user)
    {
        ud.deleteUser(user);
    }
}
