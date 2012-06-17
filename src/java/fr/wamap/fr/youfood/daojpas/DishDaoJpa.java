/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.DishDao;
import fr.wamap.youfood.entities.Dish;
import fr.wamap.youfood.entities.YFOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class DishDaoJpa implements DishDao{

    @PersistenceContext
    EntityManager em;
    
    @Override
    public void createDish(Dish dish) {
        
        em.persist(dish);
    }

    @Override
    public List<Dish> getDishesByOrder(YFOrder order) {
        
        return em.createQuery("SELECT d FROM Dish d").getResultList();//em.find(Order.class, order.getIdOrder()).getDishesList();
    }

    @Override
    public void deleteDish(Dish dish) {
        
        em.remove(dish);
    }
    
    
}
