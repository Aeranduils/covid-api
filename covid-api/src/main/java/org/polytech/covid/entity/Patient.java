package org.polytech.covid.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
    @Id
    private Integer idPatient;
    //@Column(name = "last_name") // Renommer la colonne dans la BDD
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String mail;
    @Column(nullable = false)
    private String phone;

    public Patient() {
    }
    public Integer getIdPatient() {
        return idPatient;
    }
    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getMail() {
        return mail;
    }
    public void setMail(String mail) {
        this.mail = mail;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
