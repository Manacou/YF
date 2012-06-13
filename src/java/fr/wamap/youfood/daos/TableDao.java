/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.Area;
import fr.wamap.youfood.entities.Restaurant;
import fr.wamap.youfood.entities.Table;
import java.util.List;
import javax.ejb.Local;

@Local
public interface TableDao {
    
    public void createTable(Table table);
    public List<Table> getTablesByArea(Area area);
    public List<Table> getTablesByRestaurant(Restaurant restaurant);
    public Table updateTable(Table table);
    public void deleteTable(Table table);
}