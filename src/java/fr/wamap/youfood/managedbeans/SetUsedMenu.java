/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.MenuService;
import fr.wamap.youfood.entities.Menu;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class SetUsedMenu {

    @EJB
    MenuService ms;
    
    private List<Menu> menus;
    private Long idMenu;

    public Long getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public List<Menu> getMenus() {
        return ms.getAllMenus();
    }
    
    public void SetUsedMenu(Menu menu2) {
        
        Menu menu = ms.getUsedMenu();
        
        ms.unsetUsedMenu(menu.getIdMenu());
        
        ms.setUsedMenu(menu2.getIdMenu());
    }
}
