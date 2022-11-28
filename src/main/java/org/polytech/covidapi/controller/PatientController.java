package org.polytech.covidapi.controller;

import org.polytech.covidapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import org.polytech.covidapi.entity.Patient;


@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;
    
    // Renvoie la liste de tous les patients
    @GetMapping(path = "/patients", produces = {"application/xml"})
    public List<Patient> getAll(){
        return patientService.findAll();
    }
    
    // Renvoie le patient {id} utiliser @PathParam
    @GetMapping(path = "/patients")
    public List<Patient> getAllByName(
        @RequestParam(name = "name", required = true) String name
    ){
        return patientService.findAllByNameLike(name);
    }

    // Créer un patient Utiliser @RequestBody et renvoyer un status code 201 Created
    @PostMapping(path = "/patients")
    public ResponseEntity<Patient> createPatient(
        @RequestBody Patient patient,
        UriComponentsBuilder uriBuilder) throws Exception{
            Patient savedPatient = patientService.save(patient);

            URI uri = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();
            return ResponseEntity.created(uri).body(savedPatient);
        }

    // Met à jour un patients
    @PutMapping(path = "/patient")
    

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    String handle(Exception ex){
        return ex.getMessage();
    }    
}

