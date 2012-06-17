/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.MenuService;
import fr.wamap.youfood.entities.Menu;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class AddMenu {

    @EJB
    private MenuService ms;
    
    private String label;
    
    private String menuE;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getMenuE() {
        return menuE;
    }

    public void setMenuE(String menuE) {
        this.menuE = menuE;
    }
    
    public void AddMenu() {
        
        Menu menu = new Menu();
        
        menu.setLabel(getLabel());
        
        Menu menuTest = ms.getMenuByLabel(getLabel());
        
        if(menuTest != null)
        {
            
            this.setMenuE("Le menu existe déjà.");
          
        }
        else
         {
             ms.createMenu(menu);
         }

    }
}
