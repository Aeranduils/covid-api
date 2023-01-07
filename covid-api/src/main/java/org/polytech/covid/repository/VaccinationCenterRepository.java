package org.polytech.covid.repository;

import java.util.List;

import org.polytech.covid.entity.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
/*import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;*/
import org.springframework.stereotype.Repository;

@Repository
public interface VaccinationCenterRepository 
    extends JpaRepository<VaccinationCenter,Integer> {
        
        public List<VaccinationCenter> findAllByCityIgnoreCaseLike(String city);

        /*
        @Query("from VaccinationCenter v where v.city like :city")
        public List<VaccinationCenter> findAllByCity(@Param("city") String city);
         */
        
}
