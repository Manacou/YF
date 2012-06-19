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
import javax.persistence.Query;

@Stateless
public class DishDaoJpa implements DishDao{

    @PersistenceContext
    EntityManager em;
    
    @Override
    public void createDish(Dish dish) {
        
        em.persist(dish);
    }
    
    @Override
    public List<Dish> getAllDishes()
    {
        return em.createQuery("SELECT d FROM Dish d").getResultList();
    }

    @Override
    public List<Dish> getDishesByOrder(YFOrder order) {
        
        Query query = em.createQuery("SELECT d FROM Dish d WHERE d.order = :order");
        query.setParameter("order", order);
        
        
        return query.getResultList();
    }

    @Override
    public void deleteDish(Dish dish) {
        
        em.remove(dish);
    } 
}
