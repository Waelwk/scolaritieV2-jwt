package com.project.scolarite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scolarite.entities.SeanceFormation;
import com.project.scolarite.entities.SesionDeFormation;
import com.project.scolarite.repos.SeanceFormationRepository;
@Service
public class SeanceFormationServiceImp implements SeanceFormationService {
	@Autowired
	
	SeanceFormationRepository SeanceFormationRepository;
	 
	@Override
	
	public SeanceFormation saveSeanceFormation(SeanceFormation A) {
		// TODO Auto-generated method stub
		return SeanceFormationRepository.save(A);
	}

	@Override
	public SeanceFormation updateSeanceDeFormation(SeanceFormation A) {
		
		return SeanceFormationRepository.save(A);
	}

	@Override
	public void deletSeanceFormation(SeanceFormation A) {
		// TODO Auto-generated method stub
		SeanceFormationRepository.delete(A);

	}

	@Override
	public void deletSeanceFormationById(Long idSeanceFormation) {
		// TODO Auto-generated method stub
		SeanceFormationRepository.deleteById(idSeanceFormation);
	}

	@Override
	public SeanceFormation getSeanceFormation(Long idSeanceFormation) {
		// TODO Auto-generated method stub
		return SeanceFormationRepository.findById(idSeanceFormation).get();
	}

	@Override
	public List<SeanceFormation> getAllSeanceFormation() {
		// TODO Auto-generated method stub
		return SeanceFormationRepository.findAll();
	}

}
