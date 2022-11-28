package org.polytech.covidapi.service;

import java.util.List;

import org.polytech.covidapi.entity.Patient;
import org.polytech.covidapi.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;



@Service
public class PatientService {


   
    private final PatientRepository patientRepository;


    @Autowired
    public PatientService(final PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Qualifier("serializationStore")
    private PatientStore store;

    public void savePatient(Patient aPatient){
    }

    @Bean
    public PatientStore databaseStore(){
        return new PatientDataBase();
    }

    @Bean
    public PatientStore serializStore(){
        return new PatientSerialization();
    }

    

    public Patient save(Patient patient) throws Exception{
        if (!StringUtils.hasText(patient.getEmail())){
            throw new Exception("Email is required");
        }
        return patient;
    }

    public List<Patient> findAllByNameLike(String name) {
        return null;
    }

    public List<Patient> findAll() {
        return null;
    }

    
    
}
