/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.MenuService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class listMenus {

    @EJB
    MenuService ms;
    
    private DataModel listMenus = new ListDataModel();

    public DataModel getListMenus() {
        return new ListDataModel(ms.getAllMenus());
    }

    public void setListMenus(DataModel listMenus) {
        this.listMenus = listMenus;
    }
    
    public listMenus() {
    }
}
