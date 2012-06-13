/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.Menu;
import java.util.List;
import javax.ejb.Local;

@Local
public interface MenuDao {
    
    public void createMenu(Menu menu);
    public Menu getMenuById(Long id);
    public Menu getMenuByLabel(String label);
    public Menu getUsedMenu();
    public void setUsedMenu(Long idMenu);
    public void unsetUsedMenu(Long idMenu);
    public List<Menu> getAllMenus();
    public Menu updateMenu(Menu menu);
    public void deleteMenu(Menu menu);
}
