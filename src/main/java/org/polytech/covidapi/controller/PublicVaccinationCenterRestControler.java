package org.polytech.covidapi.controller;
import io.github.bucket4j.*;

import java.util.List;

import org.polytech.covidapi.entity.VaccinationCenter;
import org.polytech.covidapi.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class PublicVaccinationCenterRestControler {
    
    @Autowired
    private VaccinationCenterRepository centerRepository;

    @GetMapping(path="api/public/center")
    public List<VaccinationCenter> getVaccinatedCenter(@RequestParam("city") String city)
    {
        return centerRepository.findAllByCityLike(city);
    }


    //rajoute 10 tokens toutes les minutes
    Refill refill = Refill.intervally(10, Duration.ofMinutes(1));
    //capacité max de 10 token
    Bandwidth limit = Bandwidth.classic(10, refill);
    Bucket bucket = Bucket.builder().addLimit(limit).build();

    @GetMapping(value = "/hello")
    public ResponseEntity<String> hello() {

        if(bucket.tryConsume(1)) {
           return ResponseEntity.ok("world");
        }
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS).build();
    }

    @GetMapping(value = "/infos")
    public ResponseEntity<String> infos() {

        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
        if(probe.isConsumed()) {
            return ResponseEntity.ok()
                    .header("X-Rate-Limit-Remaining", Long.toString(probe.getRemainingTokens()))
                    .body("infos");
        }
        long delaiEnSeconde = probe.getNanosToWaitForRefill() / 1_000_000_000;
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .header("X-Rate-Limit-Retry-After-Seconds", String.valueOf(delaiEnSeconde))
                .build();
    }
    
}