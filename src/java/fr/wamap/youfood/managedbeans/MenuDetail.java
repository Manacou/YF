/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.MenuService;
import fr.wamap.fr.youfood.services.ProductService;
import fr.wamap.youfood.entities.Menu;
import fr.wamap.youfood.entities.Product;
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
public class MenuDetail {

    @EJB
    MenuService ms;
    
    @EJB
    ProductService ps;
    
    private Menu menu;
    private List<Product> starters;
    private List<Product> mainDishes;
    private List<Product> desserts;

    public List<Product> getDesserts() {
        return ps.getProductsByMenuAndByType(getMenu(), Long.decode("3"));
    }

    public void setDesserts(List<Product> desserts) {
        this.desserts = desserts;
    }

    public List<Product> getMainDishes() {
        return ps.getProductsByMenuAndByType(getMenu(), Long.decode("2"));
    }

    public void setMainDishes(List<Product> mainDishes) {
        this.mainDishes = mainDishes;
    }

    public Menu getMenu() {
        return ms.getUsedMenu();
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Product> getStarters() {
        return ps.getProductsByMenuAndByType(getMenu(), Long.decode("1"));
    }

    public void setStarters(List<Product> starters) {
        this.starters = starters;
    }
    
    public MenuDetail() {
    }
}
