package org.polytech.covidapi.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
    @Id
    private Integer id;

    @OneToOne(mappedBy = "address")
    private Patient patient;


}


