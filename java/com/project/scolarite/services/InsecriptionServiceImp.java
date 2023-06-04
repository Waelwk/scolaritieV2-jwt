package com.project.scolarite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scolarite.entities.Inscription;
import com.project.scolarite.repos.InsecriptionRepository;
import com.project.scolarite.repos.SesionFormationRepository;
@Service
public class InsecriptionServiceImp implements InsecriptionServices {
	@Autowired
	InsecriptionRepository insecriptionRepository ;
	
	
	@Override
	public Inscription saveInsecription(Inscription A) {
		
		return insecriptionRepository.save(A);
	}

	@Override
	public Inscription updateInsecription(Inscription A) {
		// TODO Auto-generated method stub
		return insecriptionRepository.save(A);
	}

	@Override
	public void deletInsecription(Inscription A) {
		// TODO Auto-generated method stub
		insecriptionRepository.delete(A);

	}

	@Override
	public void deletInsecriptionById(Long CodeInscription) {
		insecriptionRepository.deleteById(CodeInscription);

	}

	@Override
	public Inscription getInsecription(Long CodeInscription) {
		
		return insecriptionRepository.findById(CodeInscription).get();
	}

	@Override
	public List<Inscription> getAllInsecription() {
		// TODO Auto-generated method stub
		return insecriptionRepository.findAll();
	}

}
