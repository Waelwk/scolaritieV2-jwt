package com.project.scolarite.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.entities.SesionDeFormation;
import com.project.scolarite.repos.SesionFormationRepository;
@Service
public class sesionDeFormationServicesImp implements SesionFormationServices {
	
	@Autowired
	SesionFormationRepository  sesionFormationRepository ;
	
	@Autowired
	private SesionFormationRepository sessionFormationRepository;


	
	@Override
	public SesionDeFormation saveSesionDeFormation(SesionDeFormation A) {
		
		return sesionFormationRepository.save(A);
	}

	
	
	
	@Override
	public SesionDeFormation  updateSesionDeFormation (SesionDeFormation A) {
		// TODO Auto-generated method stub
		return sesionFormationRepository.save(A);
	}

	@Override
	public void deletSesionDeFormation(SesionDeFormation A) {
		sesionFormationRepository.delete(A);

	}

	@Override
	public void deletSesionDeFormationById(Long id) {
		sesionFormationRepository.deleteById(id);

	}

	@Override
	public SesionDeFormation getSesionDeFormation(Long idSessionFormation) {
		// TODO Auto-generated method stub
		return sesionFormationRepository.findById(idSessionFormation).get();
	}
	@Override
	public List<SesionDeFormation> getAllSesionDeFormation() {
		// TODO Auto-generated method stub
		return sesionFormationRepository.findAll();
	}

}
