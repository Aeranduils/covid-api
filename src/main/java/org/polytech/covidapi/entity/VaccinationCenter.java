package org.polytech.covidapi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class VaccinationCenter {

    public VaccinationCenter(){

    }

    public VaccinationCenter(Integer id, String name, String address, String postalCode, String city,
            List<Booking> bookings) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.postalCode = postalCode;
        this.city = city;
        this.bookings = bookings;
    }

    @Id
    private Integer id;
    private String name;
    private String address;
    private String postalCode;
    private String city;

    @OneToMany(mappedBy = "center")
    private List<Booking> bookings;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }  
}
