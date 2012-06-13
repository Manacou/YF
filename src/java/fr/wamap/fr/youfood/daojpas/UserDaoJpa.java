/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.UserDao;
import fr.wamap.youfood.entities.User;
import fr.wamap.youfood.entities.UserStatus;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserDaoJpa implements UserDao{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void createUser(User user) {
        
        em.persist(user);
    }

    @Override
    public User getUserByLogin(String login) {
        
        Query query = em.createQuery("SELECT u FROM User u WHERE u.login = :login");
        query.setParameter("login", login);
        
        return (User)query.getSingleResult();
    }

    @Override
    public List<User> getUsersByUserStatus(UserStatus userStatus) {
        
        return em.find(UserStatus.class, userStatus.getIdUserStatus()).getUsers();
    }

    @Override
    public List<User> getAllUsers() {
        
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public User updateUser(User user) {
        
        return em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        
        em.remove(user);
    }
}
