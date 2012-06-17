/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.Menu;
import fr.wamap.youfood.entities.Product;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ProductDao {
    
    public void createProduct(Product product);
    public Product getProductById(Long id);
    public List<Product> getProductsByMenu(Menu menu);
    public List<Product> getAllProducts();
    public List<Product> getProductsByMenuAndByType(Menu menu, Long idType);
    public Product updateProduct(Product product);
    public void deleteProduct(Product product);
}
