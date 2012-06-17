/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.OrderDao;
import fr.wamap.youfood.entities.YFOrder;
import fr.wamap.youfood.entities.YFTable;
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
    public YFOrder getOrderById(Long idOrder)
    {
        return em.find(YFOrder.class, idOrder);
    }

    @Override
    public List<YFOrder> getOrdersbyStatus(int status) {
        
        Query query = em.createQuery("SELECT o FROM YFOrder o WHERE o.status = :status");
        query.setParameter("status", status);
        
        return query.getResultList();
    }

    @Override
    public YFOrder updateOrder(YFOrder order) {
        
        return em.merge(order);
    }
    
    @Override
    public YFOrder getReadyOrderByTable(YFTable table)
    {
        Query query = em.createQuery("SELECT o FROM YFOrder o WHERE o.table = :idTable AND o.status = 2");
        query.setParameter("idTable", table);
        
        
        return (YFOrder) query.getSingleResult();
    }
    

    @Override
    public void setDelivered(YFOrder order)
    {
        order.setStatus(3);
        em.merge(order);
    }
    
    @Override
    public void setReady(YFOrder order)
    {
        order.setStatus(2);
        em.merge(order);
    }
    
    @Override
    public void deleteOrder(YFOrder order) {
        
        em.remove(order);
    }
}
