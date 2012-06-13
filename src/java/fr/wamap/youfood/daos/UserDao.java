/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.User;
import fr.wamap.youfood.entities.UserStatus;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UserDao {
    
    public void createUser(User user);
    public User getUserByLogin(String login);
    public List<User> getUsersByUserStatus(UserStatus userStatus);
    public List<User> getAllUsers();
    public User updateUser(User user);
    public void deleteUser(User user);
}