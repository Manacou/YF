/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.YFOrder;
import java.util.List;
import javax.ejb.Local;

@Local
public interface OrderDao {
    
    public void createOrder(YFOrder order);
    public List<YFOrder> getOrdersbyStatus(int status);
    public YFOrder updateOrder(YFOrder order);
    public void deleteOrder(YFOrder order);
}