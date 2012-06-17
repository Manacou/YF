/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.AreaDao;
import fr.wamap.youfood.entities.Area;
import fr.wamap.youfood.entities.Restaurant;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AreaService {
    
    @EJB
    AreaDao ad;
    
    public void createArea(Area area)
    {
        ad.createArea(area);
    }
    
    public Area getAreaById(Long id)
    {
        return ad.getAreaById(id);
    }
    public List<Area> getAreasByRestaurant(Restaurant restaurant)
    {
        return ad.getAreasByRestaurant(restaurant);
    }
    
    public Area updateArea(Area area)
    {
        return ad.updateArea(area);
    }
    
    public void deleteArea(Area area)
    {
        ad.deleteArea(area);
    }
}
