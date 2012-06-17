/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.RestaurantDao;
import fr.wamap.youfood.entities.Restaurant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class RestaurantDaoJpa implements RestaurantDao{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void createRestaurant(Restaurant restaurant) {
        
        em.merge(restaurant);
    }
    
    @Override
    public Restaurant getRestaurantById(Long id)
    {
        return em.find(Restaurant.class,id);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        
        return em.createQuery("SELECT r FROM Restaurant r").getResultList(); 
    }

    @Override
    public Restaurant updateRestaurant(Restaurant restaurant) {
        
        return em.merge(restaurant);
    }

    @Override
    public void deleteRestaurant(Restaurant restaurant) {
        
        em.remove(restaurant);
    }
}
