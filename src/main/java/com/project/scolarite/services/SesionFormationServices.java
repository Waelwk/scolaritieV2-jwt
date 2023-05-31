package com.project.scolarite.services;

import java.util.List;


import com.project.scolarite.entities.SesionDeFormation;

public interface SesionFormationServices {
	
	

	SesionDeFormation saveSesionDeFormation(SesionDeFormation A);
	SesionDeFormation  updateSesionDeFormation (SesionDeFormation A);
	void deletSesionDeFormation(SesionDeFormation A);
	void deletSesionDeFormationById(Long idSessionFormation);
	SesionDeFormation getSesionDeFormation(Long idSessionFormation);
	List<SesionDeFormation> getAllSesionDeFormation();

}
