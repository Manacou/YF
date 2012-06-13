/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.TableDao;
import fr.wamap.youfood.entities.Area;
import fr.wamap.youfood.entities.Restaurant;
import fr.wamap.youfood.entities.Table;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class TableDaoJpa implements TableDao{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void createTable(Table table) {
        
        em.persist(table);
    }

    @Override
    public List<Table> getTablesByArea(Area area) {
        
        return em.find(Area.class, area.getIdArea()).getTables();
    }

    @Override
    public List<Table> getTablesByRestaurant(Restaurant restaurant) {
       
        List<Area> areas = em.find(Restaurant.class, restaurant.getIdRestaurant()).getAreas();
        
        List<Table> tables = null;
        
        for(int i = 0; i < areas.size(); i++)
        {
            tables.addAll(areas.get(i).getTables());
        }
        
        return tables;
    }

    @Override
    public Table updateTable(Table table) {
        
        return em.merge(table);
    }

    @Override
    public void deleteTable(Table table) {
        
        em.remove(table);
    }
}
