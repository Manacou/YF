/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.UserStatus;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserStatusDao {
    
    public void createUserStatus(UserStatus userStatus);
    public List<UserStatus> getAllUserStatuses();
    public UserStatus updateUserStatus(UserStatus userStatus);
    public void deleteUserStatus(UserStatus userStatus); 
}
