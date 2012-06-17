/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.RestaurantDao;
import fr.wamap.youfood.entities.Restaurant;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class RestaurantService {
    
    @EJB
    RestaurantDao rd;
    
    public void createRestaurant(Restaurant restaurant)
    {
        rd.createRestaurant(restaurant);
    }
    
    public Restaurant getRestaurantById(Long id)
    {
        return rd.getRestaurantById(id);
    }
    
    public List<Restaurant> getAllRestaurants()
    {
        return rd.getAllRestaurants();
    }
    
    public Restaurant updateRestaurant(Restaurant restaurant)
    {
        return rd.updateRestaurant(restaurant);
    }
    
    public void deleteRestaurant(Restaurant restaurant)
    {
        rd.deleteRestaurant(restaurant);
    }
}
