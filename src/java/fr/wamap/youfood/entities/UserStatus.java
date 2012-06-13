/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Kevin
 */
@Entity
public class UserStatus implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUserStatus;

    private String label;
    
    @OneToMany(mappedBy="userStatus")
    private List<User> users;

    public Long getIdUserStatus() {
        return idUserStatus;
    }

    public void setIdUserStatus(Long idUserStatus) {
        this.idUserStatus = idUserStatus;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
