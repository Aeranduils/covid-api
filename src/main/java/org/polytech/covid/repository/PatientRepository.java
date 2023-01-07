package org.polytech.covid.repository;

import java.time.LocalDate;
import java.util.List;

import org.polytech.covid.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{
    

   
}