/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@XmlRootElement
public class Area implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idArea;
    
    @ManyToOne
    @JoinColumn(name="restaurant_fk")
    private Restaurant restaurant;
    
    @OneToMany(mappedBy="area")
    private List<YFTable> tables;

    public Long getIdArea() {
        return idArea;
    }

    public void setIdArea(Long idArea) {
        this.idArea = idArea;
    }

    

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public List<YFTable> getTables() {
        return tables;
    }

    public void setTables(List<YFTable> tables) {
        this.tables = tables;
    } 
}
