/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.UserService;
import fr.wamap.youfood.entities.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class UserDetail {

    @EJB
    UserService us;
    
    private HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    private User user;

    public User getUser() {
        
        return us.getUserById(Long.decode(request.getParameter("id")));
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    public UserDetail() {
    }
}
