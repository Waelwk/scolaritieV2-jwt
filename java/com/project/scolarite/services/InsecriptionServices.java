package com.project.scolarite.services;

import java.util.List;

import com.project.scolarite.entities.Inscription;


public interface InsecriptionServices {
	
	Inscription saveInsecription(Inscription A);
	Inscription  updateInsecription (Inscription A);
	void deletInsecription(Inscription A);
	void deletInsecriptionById(Long CodeInscription);
	Inscription getInsecription(Long CodeInscription);
	List<	Inscription> getAllInsecription();

}



