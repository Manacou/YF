/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kevin
 */
@Entity
@XmlRootElement
public class YFOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idOrder;
    
    private int status;
    
    @ManyToOne
    @JoinColumn(name="table_fk")
    private YFTable table;
    
    public Long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Long idOrder) {
        this.idOrder = idOrder;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public fr.wamap.youfood.entities.YFTable getTable() {
        return table;
    }

    public void setTable(fr.wamap.youfood.entities.YFTable table) {
        this.table = table;
    }
}
