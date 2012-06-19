/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.OrderService;
import fr.wamap.youfood.entities.YFOrder;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


@ManagedBean
@RequestScoped
public class listOrder {

    @EJB
    OrderService os;
    
    private DataModel ordersDM = new ListDataModel();

    public DataModel getOrdersDM() {
        return new ListDataModel(os.getOrdersbyStatus(1));
    }

    public void setOrdersDM(DataModel ordersDM) {
        this.ordersDM = ordersDM;
    }
    
    public listOrder() {
    }
    
    public void setReady(YFOrder order)
    {
        os.setReady(order);
    }
    
    public void onCook(YFOrder order)
    {
        os.setOnCook(order);
    }
}
