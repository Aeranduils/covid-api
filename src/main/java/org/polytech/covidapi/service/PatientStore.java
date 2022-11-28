package org.polytech.covidapi.service;
import org.polytech.covidapi.entity.Patient;

public interface PatientStore{
    void persist(Patient aPatient);
}