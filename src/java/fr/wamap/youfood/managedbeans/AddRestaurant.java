/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.wamap.youfood.managedbeans;

import fr.wamap.fr.youfood.services.RestaurantService;
import fr.wamap.youfood.entities.Restaurant;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Kevin
 */
@ManagedBean
@RequestScoped
public class AddRestaurant {

    @EJB
    RestaurantService rs;
    
    private String number;
    private String street;
    private String zipCode;
    private String city;
    private String phoneNumber;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    
    public void AddRestaurant() {
        
        Restaurant restaurant = new Restaurant();
        
        restaurant.setCity(city);
        restaurant.setNumber(number);
        restaurant.setPhoneNumber(phoneNumber);
        restaurant.setStreet(street);
        restaurant.setZipCode(zipCode);
        
        rs.createRestaurant(restaurant);
    }
}
