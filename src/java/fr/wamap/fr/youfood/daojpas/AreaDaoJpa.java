/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.AreaDao;
import fr.wamap.youfood.entities.Area;
import fr.wamap.youfood.entities.Restaurant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AreaDaoJpa implements AreaDao{
    
    @PersistenceContext
    EntityManager em;
    
    @Override
    public void createArea(Area area)
    {
        em.persist(area);
    }
    
    @Override
    public Area getAreaById(Long id)
    {
        return em.find(Area.class, id);
    }

    @Override
    public List<Area> getAreasByRestaurant(Restaurant restaurant) {
        
        Query query = em.createQuery("SELECT a FROM Area a WHERE a.restaurant = :restaurant");
        query.setParameter("restaurant", restaurant);
        
        return query.getResultList();
    }

    @Override
    public Area updateArea(Area area) {
        
        return em.merge(area);
    }

    @Override
    public void deleteArea(Area area) {
        
        em.remove(area);
}
}
