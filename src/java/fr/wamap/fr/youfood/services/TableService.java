/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.TableDao;
import fr.wamap.youfood.entities.Area;
import fr.wamap.youfood.entities.Restaurant;
import fr.wamap.youfood.entities.Table;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TableService {
    
    @EJB
    TableDao td;
    
    public void createTable(Table table)
    {
        td.createTable(table);
    }
    
    public List<Table> getTablesByArea(Area area)
    {
        return td.getTablesByArea(area);
    }
    
    public List<Table> getTablesByRestaurant(Restaurant restaurant)
    {
        return td.getTablesByRestaurant(restaurant);
    }
    
    public Table updateTable(Table table)
    {
        return td.updateTable(table);
    }
    
    public void deleteTable(Table table)
    {
        td.deleteTable(table);
    }
}
