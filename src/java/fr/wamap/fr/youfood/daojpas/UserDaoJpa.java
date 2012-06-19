/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.UserDao;
import fr.wamap.youfood.entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
    public User getUserById(Long id)
    {
        return em.find(User.class, id);
    }

    @Override
    public User getUserByLogin(String login) {
        
        Query query = em.createQuery("SELECT u FROM User u WHERE u.login = :login");
        query.setParameter("login", login);
        
        try
        {
            return (User)query.getSingleResult();
        }
        catch(NoResultException e)
        {
            return  null;
        }
    }

    @Override
    public List<User> getAllUsers() {
        
        return em.createQuery("SELECT u FROM User u").getResultList();
    }

    @Override
    public void updateUser(User user) {
        
        
       em.merge(user);
    }

    @Override
    public void deleteUser(User user) {
        
        em.remove(user);
    }
}
