/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.OrderService;
import fr.wamap.fr.youfood.services.RestaurantService;
import fr.wamap.youfood.entities.Restaurant;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;


@ManagedBean
@RequestScoped
public class ListOrderByRestaurant {

    
    @EJB
    OrderService os;
    
    @EJB
    RestaurantService rs;
    
    private DataModel ordersDM = new ListDataModel();
    
    private HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    private Long idRestaurant;

    public Long getIdRestaurant() {
        
        Long id = this.idRestaurant;
        
        if(this.idRestaurant == null)
        {
            setIdRestaurant(Long.decode(request.getParameter("idRestaurant")));
            id = Long.decode(request.getParameter("idRestaurant"));
        }
        
        return id;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public DataModel getOrdersDM() {
        
        Restaurant restaurant = rs.getRestaurantById(getIdRestaurant());
        
        return new ListDataModel(os.getOrderByStatusAndByRestaurant(1, restaurant));
    }

    public void setOrdersDM(DataModel ordersDM) {
        this.ordersDM = ordersDM;
    }
    
    public ListOrderByRestaurant() {
    }
}
