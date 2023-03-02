package com.project.scolarite.services;

import java.util.List;

import com.project.scolarite.entities.AnneeScolaire;

public interface AnneeScolaireServices {

	 AnneeScolaire saveAnneeScolaire( AnneeScolaire A);
	 AnneeScolaire updateAnneeScolaire( AnneeScolaire A);
	void deletAnneeScolaire( AnneeScolaire A);
	void deletAnneeScolaireById(Long idAnneeScolaire);
	AnneeScolaire  getAnneeScolaire(Long idAnneeScolaire);
	List<AnneeScolaire> getAllAnneeScolaire();

}
