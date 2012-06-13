package fr.wamap.youfood.managedbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class Logout {

    /**
     * Creates a new instance of Logout
     */
    public String Logout() {
        ((HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true)).invalidate();
        
        return "test";
    }
}
