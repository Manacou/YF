/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.RestaurantService;
import fr.wamap.youfood.entities.Restaurant;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class RestaurantDetail {

    @EJB
    RestaurantService rs;
    
    private HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    private Restaurant restaurant;

    public Restaurant getRestaurant() {
        return rs.getRestaurantById(Long.decode(request.getParameter("id")));
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
    
    public RestaurantDetail() {
    }
}
