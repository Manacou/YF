/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.Restaurant;
import java.util.List;
import javax.ejb.Local;

@Local
public interface RestaurantDao {
    
    public void createRestaurant(Restaurant restaurant);
    public Restaurant getRestaurantById(Long id);
    public List<Restaurant> getAllRestaurants();
    public Restaurant updateRestaurant(Restaurant restaurant);
    public void deleteRestaurant(Restaurant restaurant);
}