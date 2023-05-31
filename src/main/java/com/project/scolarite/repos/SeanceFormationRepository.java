package com.project.scolarite.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scolarite.entities.SeanceFormation;

public interface SeanceFormationRepository extends JpaRepository<SeanceFormation, Long> {
	Optional<SeanceFormation> findById(Long Id);

}
