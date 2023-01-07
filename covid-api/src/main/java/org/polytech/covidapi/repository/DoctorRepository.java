package org.polytech.covidapi.repository;

import java.util.List;

import org.polytech.covidapi.entity.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAllByNameLike(String name);
}
