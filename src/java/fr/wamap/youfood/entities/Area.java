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
public class Area implements Serializable {
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

    public List<fr.wamap.youfood.entities.YFTable> getTables() {
        return tables;
    }

    public void setTables(List<fr.wamap.youfood.entities.YFTable> tables) {
        this.tables = tables;
    }
}
