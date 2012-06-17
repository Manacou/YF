/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.OrderDao;
import fr.wamap.youfood.entities.YFOrder;
import fr.wamap.youfood.entities.YFTable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrderService {
    
    @EJB
    OrderDao od;
    
    public void createOrder(YFOrder order)
    {
        od.createOrder(order);
    }
    
    public YFOrder getOrderById(Long idOrder)
    {
        return od.getOrderById(idOrder);
    }
    
    public List<YFOrder> getOrdersbyStatus(int status)
    {
        return od.getOrdersbyStatus(status);
    }
    
    public YFOrder updateOrder(YFOrder order)
    {
        return od.updateOrder(order);
    }
    
    public YFOrder getReadyOrderByTable(YFTable table)
    {
       return od.getReadyOrderByTable(table);
    }
    
    public void setDelivered(YFOrder order)
    {
        od.setDelivered(order);
    }
    
    public void setReady(YFOrder order)
    {
        od.setReady(order);
    }
    
    public void deleteOrder(YFOrder order)
    {
        od.deleteOrder(order);
    }
}
