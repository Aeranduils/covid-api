package org.polytech.covidapi.controller;

import org.polytech.covidapi.entity.VaccinationCenter;
import org.polytech.covidapi.repository.VaccinationCenterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.bucket4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Duration;
// import java.time.Instant;
// import java.time.ZonedDateTime;
// import java.time.temporal.ChronoUnit;
import java.util.List;

@RestController
public class PublicVaccinationCenterRestControler 
{  
    //rajoute 10 tokens toutes les minutes
    Refill refill = Refill.intervally(10, Duration.ofMinutes(1));
    //capacité max de 10 token
    Bandwidth limit = Bandwidth.classic(10, refill); //10 capa
    Bucket bucket = Bucket.builder().addLimit(limit).build(); // toute les 1 min recharge de 10 tokens

    @Autowired
    private VaccinationCenterRepository centerRepository;

   
    //code sans bucket
     // @GetMapping(path="api/public/center")
    // public List<VaccinationCenter> getVaccinatedCenter(@RequestParam("city") String city)
    // {
    
    //     //return centerRepository.findAllByCityLike("%"+city+"%"); //en comment
    //     return List.of(new VaccinationCenter(1,"Bar Polytech", "2 Rue Jean Lamour", "54500", "Nancy",List.of()));

    // }

    //code avec les buckets
    // @GetMapping(path="api/public/center")
    //   public ResponseEntity<List<VaccinationCenter>> getVaccinatedCenter(@RequestParam("city") String city)
    //  {
    //     if(bucket.tryConsume(1)) {
    //         return ResponseEntity.ok(centerRepository.findAllByCityLike("%"+city+"%"));
    //       }
    //       return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    //   }

      @GetMapping(path = "api/public/center")
      public ResponseEntity<List<VaccinationCenter>> getVaccinatedCenter(@RequestParam("city") String city)
     {
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
        if(probe.isConsumed()) {
            return ResponseEntity.ok()
            .header("X-Rate-Limit-Remaining", Long.toString(probe.getRemainingTokens()))
            .body(centerRepository.findAllByCityLike("%"+city+"%"));
          }
          long delaiEnSeconde = probe.getNanosToWaitForRefill() / 1_000_000_000;
          return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
          .header("X-Rate-Limit-Retry-After-Seconds", String.valueOf(delaiEnSeconde))
          .build();
      }
  

}

