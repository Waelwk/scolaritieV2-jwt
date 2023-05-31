package com.project.scolarite.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.scolarite.entities.Formateur;

public interface FormateurRepository extends JpaRepository<Formateur, Long> {
	

}
