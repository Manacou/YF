/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.UserStatusDao;
import fr.wamap.youfood.entities.UserStatus;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class UserStatusService {
    
    @EJB
    UserStatusDao usd;
    
    public void createUserStatus(UserStatus userStatus)
    {
        usd.createUserStatus(userStatus);
    }
    
    public List<UserStatus> getAllUserStatuses()
    {
        return usd.getAllUserStatuses();
    }
    
    public UserStatus updateUserStatus(UserStatus userStatus)
    {
        return usd.updateUserStatus(userStatus);
    }
    
    public void deleteUserStatus(UserStatus userStatus)
    {
        usd.deleteUserStatus(userStatus);
    }
}
