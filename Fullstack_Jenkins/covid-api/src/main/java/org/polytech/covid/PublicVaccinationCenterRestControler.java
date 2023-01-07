package org.polytech.covid;

import org.polytech.covid.dto.Data;

import java.time.Duration;
import java.util.List;

import io.github.bucket4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.polytech.covid.entity.VaccinationCenter;
import org.polytech.covid.repository.VaccinationCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;

@RestController
public class PublicVaccinationCenterRestControler {

    //Rajoute 10 tokens toutes les 10 minutes
    Refill refill = Refill.intervally(10, Duration.ofMinutes(1));
    // Max 10 tokens
    Bandwidth limit = Bandwidth.classic(10, refill);
    Bucket bucket = Bucket.builder().addLimit(limit).build();
    
    @Autowired
    private VaccinationCenterRepository centerRepository;

    final String remaining = "X-Rate-Limit-Remaining";
    final String retryAfter = "X-Rate-Limit-Retry-After-Seconds";

    @CrossOrigin(exposedHeaders = {remaining, retryAfter})
    @GetMapping(path="api/public/centers")
    public ResponseEntity<List<VaccinationCenter>> getVaccinationCenter(
        @RequestParam(name="city", defaultValue = "") String city){
            HttpHeaders headers = new HttpHeaders();
            ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
            if(probe.isConsumed()) { // Utilise un token
                return ResponseEntity.ok(centerRepository.findAllByCityIgnoreCaseLike("%"+city+"%"));
            }
            long delaiEnSeconde = probe.getNanosToWaitForRefill() / 1_000_000_000;
            headers.add(retryAfter, String.valueOf(delaiEnSeconde));
            return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                    .headers(headers)
                    .build();
    }

    @CrossOrigin(exposedHeaders = {remaining, retryAfter})
    @GetMapping(value = "api/infos/429")
    public ResponseEntity<Data> infos() {
        HttpHeaders headers = new HttpHeaders();
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1); // Utilise un token et vérifie ce qu'il reste
        if(probe.isConsumed()) {
            headers.add(remaining, Long.toString(probe.getRemainingTokens()));
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(new Data("Remaining tokens in bucket : " + (String)Long.toString(probe.getRemainingTokens())));
        }
        long delaiEnSeconde = probe.getNanosToWaitForRefill() / 1_000_000_000;
        headers.add(retryAfter, String.valueOf(delaiEnSeconde));
        return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
                .headers(headers)
                .body(new Data("Remaining time before refreshing : " + String.valueOf(delaiEnSeconde)));
    }
}
