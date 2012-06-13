/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.ProductService;
import fr.wamap.youfood.entities.Product;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class AddProduct {

    @EJB
    private ProductService ps;
    
    private int type;
    private String label;
    private float price;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public String AddProduct() {
        
        Product product = new Product();
        
        product.setLabel(getLabel());
        product.setType(getType());
        product.setPrice(getPrice());
        
        ps.createProduct(product);
        
        return "listProducts";
    }
}
