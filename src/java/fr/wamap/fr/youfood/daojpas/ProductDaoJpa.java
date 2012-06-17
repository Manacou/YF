/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.ProductDao;
import fr.wamap.youfood.entities.Menu;
import fr.wamap.youfood.entities.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class ProductDaoJpa implements ProductDao{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void createProduct(Product product) {
        
        em.persist(product);
    }
    
    @Override
    public Product getProductById(Long id)
    {
        return em.find(Product.class, id);
    }

    @Override
    public List<Product> getProductsByMenu(Menu menu) {
        
        Query query = em.createQuery("SELECT p FROM Product p WHERE p.menu = :menuId");
        query.setParameter("menuId", menu);
        
        return query.getResultList();
        
        
    }
    
    @Override
    public List<Product> getAllProducts()
    {
       return em.createQuery("SELECT p FROM Product p").getResultList(); 
    }
    
    @Override
    public List<Product> getProductsByMenuAndByType(Menu menu, Long idType)
    {
        try
        {
            Query query = em.createQuery("SELECT p FROM Product p WHERE p.menu = :menuId  AND p.type = :idType");
            query.setParameter("menuId", menu);
            query.setParameter("idType", idType);
            
            return query.getResultList();
        }
        catch(NoResultException e)
        {
            return null;
        }
    }
    
    @Override
    public Product updateProduct(Product product) {
        
        return em.merge(product);
    }

    @Override
    public void deleteProduct(Product product) {
        
        em.remove(product);
    }
}
