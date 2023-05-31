package com.project.scolarite.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scolarite.entities.Actualite;


public interface ActualiteRepository extends JpaRepository<Actualite, Long> {
	

}
