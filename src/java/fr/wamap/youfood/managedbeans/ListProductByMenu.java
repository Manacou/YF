/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.MenuService;
import fr.wamap.fr.youfood.services.ProductService;
import fr.wamap.youfood.entities.Menu;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class ListProductByMenu {

    @EJB
    ProductService ps;
    
    @EJB
    MenuService ms;
    
    private HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    private Long idMenu;
    private DataModel listProducts = new ListDataModel();

    public Long getIdMenu() {
        
        Long id = this.idMenu;
        
        if(id == null)
        {
            id = Long.decode(request.getParameter("id"));
            setIdMenu(id);
        }
        
        return id;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public DataModel getListProducts() {
        
        Menu menu = ms.getMenuById(getIdMenu());
        
        return new ListDataModel(ps.getProductsByMenu(menu));
    }

    public void setListProducts(DataModel listProducts) {
        this.listProducts = listProducts;
    }
       
    
    public ListProductByMenu() {
    }
}
