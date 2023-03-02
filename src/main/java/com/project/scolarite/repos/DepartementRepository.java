package com.project.scolarite.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scolarite.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
	

}
