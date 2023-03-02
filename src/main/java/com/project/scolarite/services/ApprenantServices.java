package com.project.scolarite.services;

import java.util.List;



import com.project.scolarite.entities.Apprenant;


public interface ApprenantServices {

	Apprenant saveApprenant(Apprenant A);
	Apprenant updateApprenant(Apprenant A);
	void deletApprenant(Apprenant A);
	void deletApprenantById(Long id);
	Apprenant getApprenant(Long id);
	List<Apprenant> getAllApprenant();
	
}
