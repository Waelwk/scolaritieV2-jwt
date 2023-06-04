package com.project.scolarite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.scolarite.entities.ThemeDeFormation;
import com.project.scolarite.repos.ThemeDeFormationRepository;
@Service
public class ThemeDeFormationServiceImp implements ThemeDeFormationService {
	@Autowired
	ThemeDeFormationRepository themeDeFormationRepository ;

	@Override
	public ThemeDeFormation saveThemeDeFormation(ThemeDeFormation A) {
		
		return themeDeFormationRepository.save(A);
	}

	@Override
	public ThemeDeFormation updateThemeDeFormation(ThemeDeFormation A) {
		// TODO Auto-generated method stub
		return themeDeFormationRepository.save(A);
	}

	@Override
	public void deletThemeDeFormation(ThemeDeFormation A) {
		// TODO Auto-generated method stub
	 themeDeFormationRepository.delete(A);
	}

	@Override
	public void deletThemeDeFormation(Long idThemeDeFormation) {
		// TODO Auto-generated method stub
		 themeDeFormationRepository.deleteById(idThemeDeFormation);

	}

	@Override
	public ThemeDeFormation getThemeDeFormation(Long idThemeDeFormation) {
		// TODO Auto-generated method stub
		return  themeDeFormationRepository.findById(idThemeDeFormation).get();
	}

	@Override
	public List<ThemeDeFormation> getThemeDeFormation() {
		// TODO Auto-generated method stub
		return themeDeFormationRepository.findAll();
	}

}
