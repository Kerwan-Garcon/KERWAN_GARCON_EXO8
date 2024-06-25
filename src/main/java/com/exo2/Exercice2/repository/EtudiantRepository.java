package com.exo2.Exercice2.repository;

import com.exo2.Exercice2.entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findOneEtudiantByNomAndPrenom(String nom, String prenom);
}
