package com.project.scolarite.repos;

import org.springframework.data.jpa.repository.JpaRepository;


import com.project.scolarite.entities.Etablissement;

public interface EtablissementRepository extends JpaRepository<Etablissement, Long> {
	

}
