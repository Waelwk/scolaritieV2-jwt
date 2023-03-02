package com.project.scolarite.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.scolarite.entities.Apprenant;

@RepositoryRestResource(path = "rest")
public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {

	
}
