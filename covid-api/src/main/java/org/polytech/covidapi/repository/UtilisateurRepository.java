package org.polytech.covidapi.repository;

import java.util.Optional;

import org.polytech.covidapi.entity.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByLogin(final String email);
}
