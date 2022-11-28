package org.polytech.covidapi.service;

import org.polytech.covidapi.entity.Patient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PatientDataBase implements PatientStore{
   
    @Value("${store.db.url}")
    private String dbUrl;

    @Override
    public void persist(Patient aPatient) {
        // TODO Auto-generated method stub
        
    }
    
}
