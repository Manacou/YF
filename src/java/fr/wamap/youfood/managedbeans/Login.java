package fr.wamap.youfood.managedbeans;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import fr.wamap.fr.youfood.services.UserService;
import fr.wamap.youfood.daos.UserDao;
import fr.wamap.youfood.entities.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class Login {

    @EJB
    private UserService us;
    
    private String login;
    private String password;
    private Long statut;
    private Long id;
    private Long idRestaurant;

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

    public Long getStatut() {
        return statut;
    }

    public void setStatut(Long statut) {
        this.statut = statut;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }
    
    
    public String Login() {
        
        User user = us.getUserByLogin(login);
    
        if (user != null)
        {
            
            if(user.getPassword().equals(password))
            {
                setId(user.getIdUser());
                setStatut(user.getIdStatus());
                //setIdRestaurant(user.getRestaurant().getIdRestaurant());
                return "test";
            }
            else
            {
                setStatut(Long.decode("0"));
                return "test";
            }
        }
        else
        {
            setStatut(Long.decode("0"));
            return "false";
        }
    }
}
