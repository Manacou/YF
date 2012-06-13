/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.Area;
import fr.wamap.youfood.entities.Restaurant;
import java.util.List;
import javax.ejb.Local;

@Local
public interface AreaDao {
    
    public void createArea(Area area);
    public List<Area> getAreasByRestaurant(Restaurant restaurant);
    public Area updateArea(Area area);
    public void deleteArea(Area area);
}
