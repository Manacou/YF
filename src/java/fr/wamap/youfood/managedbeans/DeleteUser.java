/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.UserService;
import fr.wamap.youfood.entities.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kevin
 */
@ManagedBean
@ViewScoped
public class DeleteUser {

    @EJB
    UserService us;
    
    private HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    private Long idUser;
    private String login;

    public Long getIdUser() {
        
        Long id = this.idUser;
        
        if(this.idUser == null)
        {
            id =  Long.decode(request.getParameter("id"));
        }
        
        setIdUser(id);
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        
        User user = us.getUserById(getIdUser());
        
        return user.getLogin();
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
    public String deleteUser() {
        
        User user = us.getUserById(getIdUser());
        
        user.setIdStatus(Long.decode("0"));
        
        us.updateUser(user);
        
        return "listUsers";
    }
}
