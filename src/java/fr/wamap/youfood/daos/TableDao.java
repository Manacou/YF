/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.Area;
import fr.wamap.youfood.entities.Restaurant;
import fr.wamap.youfood.entities.YFTable;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TableDao {
    
    public void createTable(YFTable table);
    public YFTable getTableById(Long id);
    public List<YFTable> getTablesByRestaurant(Restaurant restaurant);
    public List<YFTable> getTablesByArea(Area area);
    public YFTable updateTable(YFTable table);
    public void deleteTable(YFTable table);
}