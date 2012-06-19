/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.RestaurantService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class ListRestaurant {

    @EJB
    RestaurantService rs;
    
    private DataModel listRestaurants = new ListDataModel();

    public DataModel getListRestaurants() {
        return new ListDataModel(rs.getAllRestaurants());
    }

    public void setListRestaurants(DataModel listRestaurants) {
        this.listRestaurants = listRestaurants;
    }
    
    
    public ListRestaurant() {
    }
}
