package fr.wamap.youfood.managedbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Kevin
 */
@ManagedBean
@SessionScoped
public class Login {

    private String login;
    private String password;
    private boolean statut;

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

    public boolean isStatut() {
        return statut;
    }

    public void setStatut(boolean statut) {
        this.statut = statut;
    }
    
    public String Login() {
        if(getLogin().equals("Tzoreol") && getPassword().equals("reunion"))
        {
            setStatut(true);
           return "test";
        }
        else
        {
            setStatut(false);
            return "test";
        }
    }
}
