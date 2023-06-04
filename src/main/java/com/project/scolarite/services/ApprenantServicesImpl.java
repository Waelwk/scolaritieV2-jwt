package com.project.scolarite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.entities.Formateur;
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
		
		
		  String newPassword = A.getPassword();
		  
		  Optional<Apprenant> optionalApprenant = apprenantRepository.findById(A.getId());
	        if (optionalApprenant.isPresent()) {
	        	if( newPassword.isEmpty()) {
	        	Apprenant Apprenant = optionalApprenant.get();
	        	Apprenant.setAdresse(A.getAdresse());
	        	Apprenant.setDateNaissanceApprenant(A.getDateNaissanceApprenant());
	        	Apprenant.setNiveauApprenant(A.getNiveauApprenant());
	        	Apprenant.setEmail(A.getEmail());
	        	Apprenant.setNom(A.getNom());
	        //	Apprenant.setPassword(A.getPassword());
	        	
	        	
	        	Apprenant.setPrenom(A.getPrenom());
	        	Apprenant.setTel(A.getTel());
	        	Apprenant.setQualiteApprenant(A.getQualiteApprenant());
	        	   return UserRepository.save(Apprenant);}
	        }
		  

	        A.setPassword(new BCryptPasswordEncoder().encode(A.getPassword()));
		
			A.setRole(Role.APPRENANT);
	        return UserRepository.save(A);
	
		
		
		
       
   


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
