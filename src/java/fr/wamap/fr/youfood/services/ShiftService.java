/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.fr.youfood.services;

import fr.wamap.youfood.daos.ShiftDao;
import fr.wamap.youfood.entities.Shift;
import fr.wamap.youfood.entities.User;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ShiftService {
    
    @EJB
    ShiftDao sd;
    
    public void createShift(Shift shift)
    {
        sd.createShift(shift);
    }
    
    public List<Shift> getShiftsByUser(User user)
    {
        return sd.getShiftsByUser(user);
    }
    
    public List<Shift> getAllShifts()
    {
        return sd.getAllShifts();
    }
    
    public Shift updateShift(Shift shift)
    {
        return sd.updateShift(shift);
    }
    
    public void deleteShift(Shift shift)
    {
        sd.deleteShift(shift);
    }    
}
