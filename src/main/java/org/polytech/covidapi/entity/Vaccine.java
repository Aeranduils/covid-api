package org.polytech.covidapi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vaccine {
    @Id
    private Integer id;

    @ManyToMany(mappedBy = "vaccines")
    private List<Patient> patients;

}
