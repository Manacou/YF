/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.UserService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class ListUsers {

    @EJB
    UserService us;
    
    DataModel listUsers = new ListDataModel();

    public DataModel getListUsers() {
        
        return new ListDataModel(us.getAllUsers());
    }

    public void setListUsers(DataModel listUsers) {
        this.listUsers = listUsers;
    }
    
    
    public void ListUsers() {
    }
}
