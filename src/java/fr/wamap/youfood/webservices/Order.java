/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.webservices;

import fr.wamap.fr.youfood.services.OrderService;
import fr.wamap.fr.youfood.services.TableService;
import fr.wamap.youfood.entities.YFOrder;
import fr.wamap.youfood.entities.YFTable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public class Order {
    
    @EJB
    OrderService os;
    
    @EJB
    TableService ts;
    
    @WebMethod
    public String[] getFinishedOrder()
    {
        List<YFOrder> finishedOrders = os.getOrdersbyStatus(3);
        List<String> rtn = new ArrayList<String>();
        
        for(int i = 0; i < finishedOrders.size(); i++)
        {
            rtn.add("Table " + finishedOrders.get(i).getTable().getIdTable());
        }
        
        return rtn.toArray(new String[rtn.size()]);
    }
    
    @WebMethod
    public String setDelivered(@WebParam(name="idTable")String str)
    {
        Long idTable = Long.decode(str);
        YFTable table = ts.getTableById(idTable);
        
        YFOrder order = os.getReadyOrderByTable(table);
        os.setDelivered(order);
        
        return "ok";
    }
}
