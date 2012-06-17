/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.*;
import fr.wamap.youfood.entities.Dish;
import fr.wamap.youfood.entities.Product;
import fr.wamap.youfood.entities.YFOrder;
import fr.wamap.youfood.entities.YFTable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Kevin
 */
@ManagedBean
@ApplicationScoped
public class OrderMB {

    @EJB
    ProductService ps;
    
    @EJB
    MenuService ms;
    
    @EJB
    OrderService os;
    
    @EJB
    TableService ts;
    
    @EJB
    DishService ds;
    
    private HttpServletRequest request=(HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
    
    private List<Product> startersList;
    private List<Product> mainDishesList;
    private List<Product> dessertsList;
    private Long[] productIds = new Long[100];
    private Long[] productQuantities = new Long[100];
    private Long idTable;

    public Long[] getProductIds() {
        
        return productIds;
    }

    public void setProductIds(Long[] productIds) {
        this.productIds = productIds;
    }
    
    public void setProductId(int index, Long idProduct)
    {
        this.productIds[index] = idProduct;
    }

    public Long[] getProductQuantities() {
       
        return productQuantities;
    }

    public void setProductQuantities(Long[] productQuantities) {
        this.productQuantities = productQuantities;
    }

    public void setQuantity(int index, Long quantity)
    {
        this.productQuantities[index] = quantity;
    }
    
    public List<Product> getStartersList() {
        
        return ps.getProductsByMenuAndByType(ms.getUsedMenu(), Long.decode("1"));
    }

    public void setStartersList(List<Product> startersList) {
        this.startersList = startersList;
    }

    public List<Product> getDessertsList() {
        return ps.getProductsByMenuAndByType(ms.getUsedMenu(), Long.decode("3"));
    }

    public void setDessertsList(List<Product> dessertsList) {
        this.dessertsList = dessertsList;
    }

    public List<Product> getMainDishesList() {
        return ps.getProductsByMenuAndByType(ms.getUsedMenu(), Long.decode("2"));
    }

    public void setMainDishesList(List<Product> mainDishesList) {
        this.mainDishesList = mainDishesList;
    }

    public Long getIdTable() {
        
        if(this.idTable == null)
        {
            setIdTable(Long.decode(request.getParameter("idTable")));
        }
        return idTable;
    }

    public void setIdTable(Long idTable) {
        this.idTable = idTable;
    }
    
    public OrderMB()
    {
        for(int i = 0; i < 100; i++)
        {
            this.productQuantities[i] = Long.decode("0");
        }
    }
    public String addOrder()
    {
        boolean isPersisted = false;
        YFOrder order = new YFOrder();
        YFTable table = ts.getTableById(getIdTable());
        
        order.setTable(table);
        order.setStatus(1);
       
        //On parcourt les quantités. Si != 0 alors on récupère le produit correspondant et on l'ajoute à la liste des plats
        for(int i = 1; i < 100; i++)
        {
            if(this.productQuantities[i] > 0)
            {
                if(!isPersisted)
                {
                     os.createOrder(order);
                     isPersisted = true;
                }
                Product product = ps.getProductById(this.productIds[i]);
                Dish dish = new Dish();
                
                dish.setProduct(product);
                dish.setOrder(order);
                dish.setQuantity(this.productQuantities[i]);
              
                ds.createDish(dish);
            }
        }
        
        return "ordered";
    }
}
