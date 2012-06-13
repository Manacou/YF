/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.UserService;
import fr.wamap.fr.youfood.services.UserStatusService;
import fr.wamap.youfood.entities.User;
import fr.wamap.youfood.entities.UserStatus;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.persistence.NoResultException;

@ManagedBean
@RequestScoped
public class AddUser {

    private String firstname;
    private String lastname;
    private String login;
    private String password;
    
    private String loginE;
    
    @EJB
    private UserService us;
    
    @EJB
    private UserStatusService uss;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLoginE() {
        return loginE;
    }

    public void setLoginE(String loginE) {
        this.loginE = loginE;
    }
    
    public String AddUser() {
        
        User user = new User();
        
        user.setLogin(getLogin());
        user.setPassword(getPassword());
        user.setFirstName(getFirstname());
        user.setLastName(getLastname());
        
        List<User> users = us.getAllUsers();
        
        
        if(users.contains(user))
        {
            
            this.setLoginE("Bad Login.");
            return "addUserFail";
          
        }
        else
         {
             UserStatus status = new UserStatus();
             status.setLabel("Administrateur");
             
             user.setUserStatus(status);
             
             us.createUser(user);
             
             return "addUserSucess";
         }       
    }
}
