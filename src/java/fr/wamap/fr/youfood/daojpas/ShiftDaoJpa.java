/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.daojpas;

import fr.wamap.youfood.daos.ShiftDao;
import fr.wamap.youfood.entities.Shift;
import fr.wamap.youfood.entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ShiftDaoJpa implements ShiftDao{
    
    @PersistenceContext
    EntityManager em;

    @Override
    public void createShift(Shift shift) {
        
        em.persist(shift);
    }

    @Override
    public List<Shift> getShiftsByUser(User user) {
        
        return em.createQuery("SELECT s FROM Shift s").getResultList();//em.find(User.class, user.getIdUser()).getShifts();
    }

    @Override
    public List<Shift> getAllShifts() {
        
        return em.createQuery("SELECT s FROM Shift s").getResultList();
    }

    @Override
    public Shift updateShift(Shift shift) {
        
        return em.merge(shift);
    }

    @Override
    public void deleteShift(Shift shift) {
        
        em.remove(shift);
    }
}
