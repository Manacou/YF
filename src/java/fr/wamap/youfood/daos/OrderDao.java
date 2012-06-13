/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.Order;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OrderDao {
    
    public void createOrder(Order order);
    public List<Order> getOrdersbyStatus(int status);
    public Order updateOrder(Order order);
    public void deleteOrder(Order order);
}