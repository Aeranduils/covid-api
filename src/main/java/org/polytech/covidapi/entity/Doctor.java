package org.polytech.covidapi.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Doctor {
    @Id
    private Integer id;

    // Un docteur à plusieurs patients, 1:n bidirectionnelle
    @OneToMany(mappedBy = "doctor", cascade = {}, fetch = FetchType.LAZY)
    private List<Patient> patients;


    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
