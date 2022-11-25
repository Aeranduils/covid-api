package org.polytech.covidapi.repository;

import java.util.List;

import org.polytech.covidapi.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository 
    extends JpaRepository<VaccinationCenter,Integer>{
    //@Query("")    
    List<VaccinationCenter> findAllByCityLike(String city);
    
}
