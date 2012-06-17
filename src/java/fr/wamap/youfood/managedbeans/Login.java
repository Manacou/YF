package fr.wamap.youfood.managedbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import fr.wamap.youfood.daos.UserDao;
import fr.wamap.youfood.entities.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Login {

    @EJB
    private UserDao userDao;
    
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
        
        User user = userDao.getUserByLogin(login);
        
        if (user != null)
        {
            if(user.getPassword().equals(password))
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
        else
        {
            setStatut(false);
            return "false";
        }
    }
}
