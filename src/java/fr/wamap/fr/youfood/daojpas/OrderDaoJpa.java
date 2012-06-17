/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.OrderDao;
import fr.wamap.youfood.entities.YFOrder;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class OrderDaoJpa implements OrderDao{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void createOrder(YFOrder order) {
        
        em.persist(order);
    }

    @Override
    public List<YFOrder> getOrdersbyStatus(int status) {
        
        Query query = em.createQuery("SELECT o FROM Order o WHERE o.status = :status");
        query.setParameter("status", status);
        
        return query.getResultList();
    }

    @Override
    public YFOrder updateOrder(YFOrder order) {
        
        return em.merge(order);
    }

    @Override
    public void deleteOrder(YFOrder order) {
        
        em.remove(order);
    }
}
