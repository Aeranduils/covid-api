package org.polytech.covid.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class VaccinationCenter {
    @Id
    private Integer idCenter;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String postalCode;
    
    @OneToMany(mappedBy = "center", fetch = FetchType.LAZY) //Selon le nom de la variable center dans Appointment
    @JsonIgnore
    private List<Appointment> appointments;

    public VaccinationCenter(Integer idCenter, String name, String city, String address, String postalCode,
            List<Appointment> appointments) {
        this.idCenter = idCenter;
        this.name = name;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
        this.appointments = appointments;
    }
    public VaccinationCenter(Integer idCenter, String name, String city, String address, String postalCode) {
        this.idCenter = idCenter;
        this.name = name;
        this.city = city;
        this.address = address;
        this.postalCode = postalCode;
    }
    public VaccinationCenter() {
    }

    public Integer getId() {
        return idCenter;
    }
    public void setId(Integer idCenter) {
        this.idCenter = idCenter;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
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
    public List<Appointment> getAppointments() {
        return appointments;
    }
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}



