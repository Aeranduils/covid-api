package org.polytech.covid.repository;

import java.util.Optional;

import org.polytech.covid.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Optional<Utilisateur> findByLogin(final String email);
}
