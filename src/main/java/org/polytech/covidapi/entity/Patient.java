package org.polytech.covidapi.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Patient {
    @Id
    private Integer id;

    // Un patient à une seul et unique adresse
    @OneToOne(cascade = {})
    /*@JoinColumn(
        name = "id_address",
        foreignKey = @ForeignKey(name = "address_fk"),
        nullable = false)*/
    private Address address;

    // Plusieurs patient ont le même docteur, 1:n bidirectionelle
    @ManyToOne
    private Doctor doctor;

    @ManyToMany
    private List<Vaccine> vaccines;

    private String firstName;
    private String lastName;
    private String postalCode;
    private String city;
    private Date birthDate;
    private String email;

    @OneToMany(mappedBy = "center")
    private List<Booking> bookings;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
    public Date getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Booking> getBookings() {
        return bookings;
    }
    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }


    
}


