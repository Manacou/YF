/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.TableDao;
import fr.wamap.youfood.entities.Area;
import fr.wamap.youfood.entities.Restaurant;
import fr.wamap.youfood.entities.YFTable;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class TableService {
    
    @EJB
    TableDao td;
    
    public void createTable(YFTable table)
    {
        td.createTable(table);
    }
    
    public YFTable getTableById(Long id)
    {
        return td.getTableById(id);
    }
    
    public List<YFTable> getTablesByArea(Area area)
    {
        return td.getTablesByArea(area);
    }
    
    public List<YFTable> getTablesByRestaurant(Restaurant restaurant)
    {
        return td.getTablesByRestaurant(restaurant);
    }
    
    public YFTable updateTable(YFTable table)
    {
        return td.updateTable(table);
    }
    
    public void deleteTable(YFTable table)
    {
        td.deleteTable(table);
    }
}
