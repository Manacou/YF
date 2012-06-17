/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.entities;

import java.io.Serializable;
import java.security.Timestamp;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@XmlRootElement
public class Shift implements Serializable {
    private static final long serialVersionUID = 1L;
      @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idShift;
    
    @ManyToOne
    @JoinColumn(name="user_fk")
    private User user;
    
    @ManyToOne
    @JoinColumn(name="area_fk")
    private Area area;
    
    private Timestamp beginTS;
    private Timestamp finishTS;

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Timestamp getBeginTS() {
        return beginTS;
    }

    public void setBeginTS(Timestamp beginTS) {
        this.beginTS = beginTS;
    }

    public Timestamp getFinishTS() {
        return finishTS;
    }

    public void setFinishTS(Timestamp finishTS) {
        this.finishTS = finishTS;
    }

    public Long getIdShift() {
        return idShift;
    }

    public void setIdShift(Long idShift) {
        this.idShift = idShift;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
