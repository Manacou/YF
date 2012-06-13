/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.ProductService;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

/**
 *
 * @author Kevin
 */
@ManagedBean
@ViewScoped
public class ListProduct {

    @EJB
    ProductService ps;
    
    private DataModel productsDM = new ListDataModel();

    public DataModel getProductsDM() {
        return new ListDataModel(ps.getAllProducts());
    }

    public void setProductsDM(DataModel productsDM) {
        this.productsDM = productsDM;
    }
    
    
    public void ListProduct() {
        
        setProductsDM(new ListDataModel(ps.getAllProducts()));
    }
}
