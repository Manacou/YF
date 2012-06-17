/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.DishService;
import fr.wamap.fr.youfood.services.OrderService;
import fr.wamap.youfood.entities.YFOrder;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class DetailOrder {

    @EJB
    DishService ds;
            
    @EJB
    OrderService os;
            
    private DataModel dishesList = new ListDataModel();
    
    private HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();

    public DataModel getDishesList() {
        
        YFOrder order = os.getOrderById(Long.decode(request.getParameter("id")));
        
        return new ListDataModel(ds.getDishesByOrder(order));
    }

    public void setDishesList(DataModel dishesList) {
        this.dishesList = dishesList;
    }
    
    
    public DetailOrder() {
    }
}
