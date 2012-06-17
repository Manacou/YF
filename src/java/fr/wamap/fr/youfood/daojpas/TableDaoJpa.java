/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.TableDao;
import fr.wamap.youfood.entities.Area;
import fr.wamap.youfood.entities.Restaurant;
import fr.wamap.youfood.entities.YFTable;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TableDaoJpa implements TableDao{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void createTable(YFTable table) {
        
        em.persist(table);
    }
    
    @Override
    public YFTable getTableById(Long id)
    {
        return em.find(YFTable.class, id);
    }

    @Override
    public List<YFTable> getTablesByArea(Area area) {
        
        return em.find(Area.class, area.getIdArea()).getTables();
    }

    @Override
    public List<YFTable> getTablesByRestaurant(Restaurant restaurant) {
       
        List<Area> areas = em.find(Restaurant.class, restaurant.getIdRestaurant()).getAreas();
        
        List<YFTable> tables = null;
        
        for(int i = 0; i < areas.size(); i++)
        {
            tables.addAll(areas.get(i).getTables());
        }
        
        return tables;
    }

    @Override
    public YFTable updateTable(YFTable table) {
        
        return em.merge(table);
    }

    @Override
    public void deleteTable(YFTable table) {
        
        em.remove(table);
    }
}
