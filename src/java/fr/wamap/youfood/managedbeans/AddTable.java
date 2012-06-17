/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.AreaService;
import fr.wamap.fr.youfood.services.RestaurantService;
import fr.wamap.fr.youfood.services.TableService;
import fr.wamap.youfood.entities.Area;
import fr.wamap.youfood.entities.Restaurant;
import fr.wamap.youfood.entities.YFTable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kevin
 */
@ManagedBean
@ViewScoped
public class AddTable{

    @EJB
    RestaurantService rs;
    
    @EJB
    AreaService as;
    
    @EJB
    TableService ts;
    
    private HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    private List<Area> listAreas;
    private Long idArea;
    private int nbSeats;
    private Long idRestaurant;

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }

    public List<Area> getListAreas() {
        
        if(idRestaurant == null)
        {
            
           setIdRestaurant(Long.decode(request.getParameter("idRestaurant")));
           
        }
        
        Restaurant restaurant = rs.getRestaurantById(getIdRestaurant());
        
        return as.getAreasByRestaurant(restaurant);
    }

    public void setListAreas(List<Area> listAreas) {
        this.listAreas = listAreas;
    }

    public int getNbSeats() {
        return nbSeats;
    }

    public void setNbSeats(int nbSeats) {
        this.nbSeats = nbSeats;
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }
    
    public void AddTable() {
        
            YFTable table = new YFTable();
            Area area = as.getAreaById(getIdArea());
        
            table.setArea(area);
            table.setNbSeats(getNbSeats());
        
            ts.createTable(table); 
        
    }
}
