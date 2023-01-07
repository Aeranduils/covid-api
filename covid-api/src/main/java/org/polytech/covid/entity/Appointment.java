package org.polytech.covid.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Appointment {
    @Id
    private Integer idAppointment;

    @ManyToOne(optional = false) //Obligatoire de la renseigner
    @JoinColumn(name = "idPatient", nullable = false, 
        foreignKey = @ForeignKey(name = "fk_idPatient"))
    private Patient patient;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idCenter", nullable = false,
        foreignKey = @ForeignKey(name = "fk_idCenter"))
    private VaccinationCenter center;

    public Appointment() {
    }
    public Integer getIdAppointment() {
        return idAppointment;
    }
    public void setIdAppointment(Integer idAppointment) {
        this.idAppointment = idAppointment;
    }
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public VaccinationCenter getCenter() {
        return center;
    }
    public void setCenter(VaccinationCenter center) {
        this.center = center;
    }
}
