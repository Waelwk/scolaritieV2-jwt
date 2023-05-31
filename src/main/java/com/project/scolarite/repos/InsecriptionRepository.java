package com.project.scolarite.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scolarite.entities.Inscription;
import com.project.scolarite.entities.SeanceFormation;




public interface InsecriptionRepository extends JpaRepository< Inscription, Long> {
	Optional<Inscription> findById(Long Id);
}
