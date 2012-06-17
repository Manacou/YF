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
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kevin
 */
@ManagedBean
@ViewScoped
public class AddProductToMenu {
    
    @EJB
    private ProductService ps;
    
    @EJB
    private MenuService ms;
    
    private HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    private String label;
    private List<Menu> menuList;
    private Long idProduct;
    private Long idMenu;

    public String getLabel() {

        
        if (idProduct == null)
        {
            setIdProduct(Long.decode(request.getParameter("id")));
        }
        
        Product product = ps.getProductById(getIdProduct());
       
        return product.getLabel();
    }

    public void setLabel(String idMenu) {
        this.label = idMenu;
    }

    public List<Menu> getMenuList() {
        
        return ms.getAllMenus();
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Long getIdMenu() {
        
        if (idMenu == null)
        {
           idMenu = Long.decode(request.getParameter("id"));
        }
        
        return idMenu;
    }

    public void setIdMenu(Long idMenu) {
        this.idMenu = idMenu;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }
    
    public String AddProductToMenu() {
        
        try
        {
            Product product = ps.getProductById(getIdProduct());
        
            Menu menu = ms.getMenuById(getIdMenu());
        
            product.setMenu(menu);
        
            ps.updateProduct(product);
            
            return "ok";
        }
        catch(Exception e)
        {
            return "nok";
        }
    }
}
