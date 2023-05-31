package com.project.scolarite.services;

import java.util.List;

import com.project.scolarite.entities.SeanceFormation;
import com.project.scolarite.entities.SesionDeFormation;

public interface SeanceFormationService {
	

	SeanceFormation saveSeanceFormation(SeanceFormation A);
	SeanceFormation  updateSeanceDeFormation (SeanceFormation  A);
	void deletSeanceFormation(SeanceFormation A);
	void deletSeanceFormationById(Long idSeanceFormation);
	SeanceFormation getSeanceFormation(Long idSeanceFormation);
	List<SeanceFormation> getAllSeanceFormation();


}
