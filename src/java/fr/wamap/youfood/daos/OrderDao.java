/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.Restaurant;
import fr.wamap.youfood.entities.YFOrder;
import fr.wamap.youfood.entities.YFTable;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OrderDao {
    
    public void createOrder(YFOrder order);
    public YFOrder getOrderById(Long idOrder);
    public List<YFOrder> getOrdersbyStatus(int status);
    public List<YFOrder> getOrderByStatusAndByRestaurant(int status, Restaurant restaurant);
    public YFOrder getReadyOrderByTable(YFTable table);
    public void setDelivered(YFOrder Order);
    public void setReady(YFOrder Order);
    public void setOnCook(YFOrder Order);
    public YFOrder updateOrder(YFOrder order);
    public void deleteOrder(YFOrder order);
}