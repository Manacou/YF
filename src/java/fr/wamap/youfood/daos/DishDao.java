/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.Dish;
import fr.wamap.youfood.entities.Order;
import java.util.List;
import javax.ejb.Local;

@Local
public interface DishDao {
    
    public void createDish(Dish dish);
    public List<Dish> getDishesByOrder(Order order);
    public void deleteDish(Dish dish);
}