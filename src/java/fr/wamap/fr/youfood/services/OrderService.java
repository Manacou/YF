/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.OrderDao;
import fr.wamap.youfood.entities.Order;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class OrderService {
    
    @EJB
    OrderDao od;
    
    public void createOrder(Order order)
    {
        od.createOrder(order);
    }
    
    public List<Order> getOrdersbyStatus(int status)
    {
        return od.getOrdersbyStatus(status);
    }
    
    public Order updateOrder(Order order)
    {
        return od.updateOrder(order);
    }
    
    public void deleteOrder(Order order)
    {
        od.deleteOrder(order);
    }
}
