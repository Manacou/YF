/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.MenuDao;
import fr.wamap.youfood.entities.Menu;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class MenuDaoJpa implements MenuDao{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void createMenu(Menu menu) {
        
        em.persist(menu);
    }

    @Override
    public Menu getMenuById(Long id)
    {
        return em.find(Menu.class, id);
    }
    
    @Override
    public Menu getMenuByLabel(String label) {
        Query query = em.createQuery("SELECT m FROM Menu m WHERE m.label = :label");
        query.setParameter("label", label);
        
        return (Menu)query.getSingleResult();
    }
    
    @Override
    public Menu getUsedMenu()
    {
        
       return  (Menu)em.createQuery("SELECT m FROM Menu m WHERE m.isUsed = 1").getSingleResult();
    }
    
    @Override
    public void setUsedMenu(Long idMenu)
    {
        Menu menu = em.find(Menu.class, idMenu);
        
        menu.setIsUsed(true);
        
        em.merge(menu);
    }
    
    @Override
    public void unsetUsedMenu(Long idMenu)
    {
        Menu menu = em.find(Menu.class, idMenu);
        
        menu.setIsUsed(false);
        
        em.merge(menu);
    }
    
    @Override
    public List<Menu> getAllMenus() {
        
        return em.createQuery("SELECT m FROM Menu m").getResultList();
    }

    @Override
    public Menu updateMenu(Menu menu) {
        
        return em.merge(menu);
    }

    @Override
    public void deleteMenu(Menu menu) {
        
        em.remove(menu);
    }
}
