/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.DishDao;
import fr.wamap.youfood.entities.Dish;
import fr.wamap.youfood.entities.YFOrder;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class DishService {
    
    @EJB
    DishDao dd;
    
    public void createDish(Dish dish)
    {
        dd.createDish(dish);
    }
    
    public List<Dish> getAllDishes()
    {
        return dd.getAllDishes();
    }
    public List<Dish> getDishesByOrder(YFOrder order)
    {
        return dd.getDishesByOrder(order);
    }
    
    public void deleteDish(Dish dish)
    {
        dd.deleteDish(dish);
    }
}
