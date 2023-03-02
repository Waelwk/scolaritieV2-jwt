package com.project.scolarite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scolarite.entities.AnneeScolaire;

import com.project.scolarite.repos.AnneeScolaireRepository;
@Service
public class AnneeScolaireServicesImp implements AnneeScolaireServices {
	@Autowired
	AnneeScolaireRepository   anneeScolaireRepository;
	 
	@Override
	public AnneeScolaire saveAnneeScolaire(AnneeScolaire A) {
		// TODO Auto-generated method stub
		return anneeScolaireRepository.save(A);
	}

	@Override
	public AnneeScolaire updateAnneeScolaire(AnneeScolaire A) {
		// TODO Auto-generated method stub
		return anneeScolaireRepository.save(A);
	}

	@Override
	public void deletAnneeScolaire(AnneeScolaire A) {
		// TODO Auto-generated method stub
	 anneeScolaireRepository.delete(A);
	}

	@Override
	public void deletAnneeScolaireById(Long idAnneeScolaire) {
		// TODO Auto-generated method stub
		 anneeScolaireRepository.deleteById(idAnneeScolaire);
	}

	@Override
	public AnneeScolaire getAnneeScolaire(Long idAnneeScolaire) {
		// TODO Auto-generated method stub
		return anneeScolaireRepository.findById(idAnneeScolaire).get();
	}

	@Override
	public List<AnneeScolaire> getAllAnneeScolaire() {
		// TODO Auto-generated method stub
		return anneeScolaireRepository.findAll() ;
	}

}
