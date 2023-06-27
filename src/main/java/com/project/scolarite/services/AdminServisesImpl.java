package com.project.scolarite.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.scolarite.entities.Admin;
import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.entities.Role;
import com.project.scolarite.repos.AdminRepo;
import com.project.scolarite.repos.UserRepository;
@Service
public class AdminServisesImpl implements AdminServises {
	 @Autowired
	    private EmailVerificationService emailVerificationService;
	@Autowired
	  UserRepository UserRepository;
	@Autowired
	  AdminRepo AdminRepository;
	@Override
	public Admin saveAdmin(Admin A) {
A.setPassword(new BCryptPasswordEncoder().encode(A.getPassword()));
		
		A.setRole(Role.ADMIN);
        A.setVerified(false);
		
	     emailVerificationService.sendVerificationEmail(A);
				
		return  UserRepository.save(A);
	}

	@Override
	public Admin updateAdmin(Admin A) {
		  String newPassword = A.getPassword();
		  
		  Optional<Admin> optionalApprenant = AdminRepository.findById(A.getId());
	        if (optionalApprenant.isPresent()) {
	        	if( newPassword.isEmpty()) {
	        	Admin Apprenant = optionalApprenant.get();
	        	Apprenant.setAdresse(A.getAdresse());
	        
	        	Apprenant.setEmail(A.getEmail());
	        	Apprenant.setNom(A.getNom());
	        //	Apprenant.setPassword(A.getPassword());
	        	Apprenant.setVerified(true);
	        	
	        	Apprenant.setPrenom(A.getPrenom());
	        	Apprenant.setTel(A.getTel());
	        	
	        	   return UserRepository.save(Apprenant);}
	        }
		  

	        A.setPassword(new BCryptPasswordEncoder().encode(A.getPassword()));
		
			A.setRole(Role.ADMIN);
	        return UserRepository.save(A);
	
		
		
		
     
 


	}
	

	@Override
	public void deletAdmin(Admin A) {
		AdminRepository.delete( A);
	}

	@Override
	public void deletAdminById(Long id) {
		AdminRepository.deleteById( id);

	}

	@Override
	public Admin getAdmin(Long id) {
		// TODO Auto-generated method stub
		return AdminRepository.findById(id).get();
	}

	@Override
	public List<Admin> getAllAdmin() {
		// TODO Auto-generated method stub
		return AdminRepository.findAll();
	}

}
