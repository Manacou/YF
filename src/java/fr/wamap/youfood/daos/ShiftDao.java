/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.daos;

import fr.wamap.youfood.entities.Shift;
import fr.wamap.youfood.entities.User;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ShiftDao {
    
    public void createShift(Shift shift);
    public List<Shift> getShiftsByUser(User user);
    public List<Shift> getAllShifts();
    public Shift updateShift(Shift shift);
    public void deleteShift(Shift shift);
}