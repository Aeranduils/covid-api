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

    @GetMapping(path="api/public/centers")
    public List<VaccinationCenter> getVaccinatedCenter(@RequestParam("city") String city)
    {
        return centerRepository.findAllByCityLike(city);
    }

    
}