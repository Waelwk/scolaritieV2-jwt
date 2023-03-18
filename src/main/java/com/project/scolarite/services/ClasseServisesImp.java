package com.project.scolarite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scolarite.entities.Classe;
import com.project.scolarite.repos.ClasseRepository;
@Service
public class ClasseServisesImp implements ClasseServices {
	@Autowired
	ClasseRepository classeRepository;
	
	@Override
	public Classe saveClasse(Classe A) {
		// TODO Auto-generated method stub
		return classeRepository.save(A);
	}

	@Override
	public Classe updateClasse(Classe A) {
		// TODO Auto-generated method stub
		return classeRepository.save(A);
	}

	@Override
	public void deletClasse(Classe A) {
    classeRepository.delete(A);
		
	}

	@Override
	public void deletClasseById(Long idClasse) {
	classeRepository.deleteById(idClasse);
		
	}

	@Override
	public Classe getClasse(Long idClasse) {
		// TODO Auto-generated method stub
		return	classeRepository.findById(idClasse).get();
	}

	@Override
	public List<Classe> getAllClasse() {
		// TODO Auto-generated method stub
		return classeRepository.findAll();
	}

}
