/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.ProductDao;
import fr.wamap.youfood.entities.Menu;
import fr.wamap.youfood.entities.Product;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ProductService {
    
    @EJB
    ProductDao pd;
    
    public void createProduct(Product product)
    {
        pd.createProduct(product);
    }
    
    public Product getProductById(Long id)
    {
        return pd.getProductById(id);
    }
    
    public List<Product> getProductsByMenu(Menu menu)
    {
        return pd.getProductsByMenu(menu);
    }
    
    public List<Product> getAllProducts()
    {
        return pd.getAllProducts();
    }
    
    public Product updateProduct(Product product)
    {
        return pd.updateProduct(product);
    }
    
    public void deleteProduct(Product product)
    {
        pd.deleteProduct(product);
    }
}
