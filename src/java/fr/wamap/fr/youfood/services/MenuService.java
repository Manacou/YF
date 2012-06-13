/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.MenuDao;
import fr.wamap.youfood.entities.Menu;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class MenuService {
    
    @EJB
    MenuDao md;
    
    public void createMenu(Menu menu)
    {
        md.createMenu(menu);
    }
    
    public Menu getMenuById(Long id)
    {
        return md.getMenuById(id);
    }
    
    public Menu getMenuByLabel(String label)
    {
        return md.getMenuByLabel(label);
    }
    
    public Menu getUsedMenu()
    {
        return md.getUsedMenu();
    }
    
    public void setUsedMenu(Long idMenu)
    {
        md.setUsedMenu(idMenu);
    }
    
    public void unsetUsedMenu(Long idMenu)
    {
        md.unsetUsedMenu(idMenu);
    }
    
    public List<Menu> getAllMenus()
    {
        return md.getAllMenus();
    }
    
    public Menu updateMenu(Menu menu)
    {
        return md.updateMenu(menu);
    }
    
    public void deleteMenu(Menu menu)
    {
        md.deleteMenu(menu);
    }
}
