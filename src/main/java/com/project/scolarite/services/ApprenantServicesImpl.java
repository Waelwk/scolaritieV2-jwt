package com.project.scolarite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.repos.ApprenantRepository;

@Service
public class ApprenantServicesImpl implements ApprenantServices{

	@Autowired
	ApprenantRepository apprenantRepository ;

	@Override
	public Apprenant saveApprenant(Apprenant A) {
		// TODO Auto-generated method stub
		return apprenantRepository.save(A);
	}

	@Override
	public Apprenant updateApprenant(Apprenant A) {
		
		return apprenantRepository.save(A);
	}

	@Override
	public void deletApprenant(Apprenant A) {
		// TODO Auto-generated method stub
		apprenantRepository.delete( A);
	}

	@Override
	public void deletApprenantById(Long id) {
		// TODO Auto-generated method stub
		apprenantRepository.deleteById( id);
	}

	@Override
	public Apprenant getApprenant(Long id) {
		// TODO Auto-generated method stub
		return apprenantRepository.findById(id).get();
	}

	@Override
	public List<Apprenant> getAllApprenant() {
		// TODO Auto-generated method stub
		return apprenantRepository.findAll();
	}

	
	

}
