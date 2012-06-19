/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.DishService;
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
public class listDishes {

    @EJB
    DishService ds;
    
    private DataModel listDishes = new ListDataModel();

    public DataModel getListDishes() {
        
        return new ListDataModel(ds.getAllDishes());
    }

    public void setListDishes(DataModel listDishes) {
        this.listDishes = listDishes;
    }
    
    public listDishes() {
    }
}
