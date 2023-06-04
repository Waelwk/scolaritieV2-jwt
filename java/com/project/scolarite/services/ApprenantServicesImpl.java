package com.project.scolarite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.entities.QualiteApprenant;
import com.project.scolarite.entities.Role;
import com.project.scolarite.entities.User;
import com.project.scolarite.repos.ApprenantRepository;
import com.project.scolarite.repos.UserRepository;
import com.project.scolarite.security.config.JwtService;

@Service
public class ApprenantServicesImpl implements ApprenantServices{
    @Autowired
    private EmailVerificationService emailVerificationService;
	@Autowired
	ApprenantRepository apprenantRepository ;
	@Autowired
	  UserRepository UserRepository;
	@Override
	public Apprenant saveApprenant(Apprenant A) {
		// TODO Auto-generated method stub
		A.setPassword(new BCryptPasswordEncoder().encode(A.getPassword()));
		
		A.setRole(Role.APPRENANT);
        A.setVerified(false);
		
	     emailVerificationService.sendVerificationEmail(A);
				
		return  UserRepository.save(A);
		
	}

	@Override
	public Apprenant updateApprenant(Apprenant A) {
		if(!A.getPassword().isEmpty()){
		A.setPassword(A.getPassword());
		}
		A.setRole(Role.APPRENANT);
		
		
		/*if(A.getQualiteApprenant().equals("Professionel")){
			A.setQualiteApprenant(QualiteApprenant.Professionel);
		}
		if(A.getQualiteApprenant().equals("Eleve")){
			A.setQualiteApprenant(QualiteApprenant.Eleve);
		}
		
		if(A.getQualiteApprenant().equals("Etudiant")){
			A.setQualiteApprenant(QualiteApprenant.Etudiant);}
		else {
			A.setQualiteApprenant(QualiteApprenant.Demandeur_emploie);}*/
		
		
       
   

				
		return  UserRepository.save(A);
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
