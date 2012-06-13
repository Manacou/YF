/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.UserStatusDao;
import fr.wamap.youfood.entities.UserStatus;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UserStatusDaoJpa implements UserStatusDao{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void createUserStatus(UserStatus userStatus) {
        
        em.persist(userStatus);
    }

    @Override
    public List<UserStatus> getAllUserStatuses() {
        
        return em.createQuery("SELECT us FRIM UserStatus us").getResultList();
    }

    @Override
    public UserStatus updateUserStatus(UserStatus userStatus) {
        
        return em.merge(userStatus);
    }

    @Override
    public void deleteUserStatus(UserStatus userStatus) {
        
        em.remove(userStatus);
    }
}
