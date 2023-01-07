package org.polytech.covidapi.controller;

import java.util.List;

import org.polytech.covidapi.entity.VaccinationCenter;
import org.polytech.covidapi.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PrivateVaccinationCenterRestControler 
{  
    @Autowired
    private VaccinationCenterRepository centerRepository;

    @GetMapping(path="api/private/center")
     public List<VaccinationCenter> getVaccinatedCenter(@RequestParam("city") String city)
     {
         //return centerRepository.findAllByCityLike("%"+city+"%");
         return List.of(new VaccinationCenter(1,"Bar Polytech", "2 Rue Jean Lamour", "54500", "Nancy",List.of()));
     }
 }

//  @RestController
//  @RequestMapping("login")
//  public class PrivateVaccinationCenterRestControler {
     
//      @GetMapping()
//      public ResponseEntity<Void> login() {
//          return ResponseEntity.ok().build();
//      }
// }