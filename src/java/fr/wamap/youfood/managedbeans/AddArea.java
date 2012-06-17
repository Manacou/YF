/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.AreaService;
import fr.wamap.fr.youfood.services.RestaurantService;
import fr.wamap.youfood.entities.Area;
import fr.wamap.youfood.entities.Restaurant;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class AddArea {

    @EJB
    private AreaService as;
    
    @EJB
    private RestaurantService rs;
    
    private Long idRestaurant;
    private List<Restaurant> listRestaurants;

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public List<Restaurant> getListRestaurants() {
        return rs.getAllRestaurants();
    }

    public void setListRestaurants(List<Restaurant> listRestaurants) {
        this.listRestaurants = listRestaurants;
    }
    
    public void AddArea() {
        
        Area area = new Area();
        
        Restaurant restaurant = rs.getRestaurantById(getIdRestaurant());
        
        area.setRestaurant(restaurant);
        
        as.createArea(area);
    }
}
