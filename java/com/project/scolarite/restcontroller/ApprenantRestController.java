package com.project.scolarite.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.repos.UserRepository;
import com.project.scolarite.services.ApprenantServices;
import com.project.scolarite.services.EmailVerificationService;

@RestController
@RequestMapping("/api/apprenant")
@CrossOrigin
public class ApprenantRestController {
	@Autowired
	ApprenantServices apprenantService;
	  UserRepository UserRepository;
	
	  @Autowired
	    private EmailVerificationService emailVerificationService;
	  
		
		@GetMapping("/verify-email")
	    public ResponseEntity<String> verifyEmail(@RequestParam("token") String token) {
	        try {
	            emailVerificationService.verifyEmail(token);
	            
	            return ResponseEntity.ok("<h1>Email verified successfully</h1>");
	        } catch (IllegalArgumentException e) {
	            return ResponseEntity.badRequest().body(e.getMessage());
	        }
	    }
	@GetMapping
	
	
	public List<Apprenant> getAllApprenant() {
		
	return apprenantService.getAllApprenant();
	}
	
	@GetMapping("/{idApprenant}")
	public Apprenant getApprenantById(@PathVariable("idApprenant") Long idApprenant) {
		return apprenantService.getApprenant(idApprenant);
	}
	
	@PostMapping("/add") 
	public Apprenant createApprenant(@RequestBody Apprenant apprenant) {
	
	
		return apprenantService.saveApprenant(apprenant);
	}

	@PutMapping("/{idApprenant}") 
	
	public Apprenant updateApprenantt(@RequestBody Apprenant apprenant) {
		
	return apprenantService.updateApprenant(apprenant);
	
	
	}
	
	@RequestMapping(value="/{idApprenant}/patch",method = RequestMethod.PUT)
	public Apprenant patchApprenantt(@RequestBody Apprenant apprenant) {
		
		apprenant.setArchiveApprenant(true);
	return apprenantService.updateApprenant(apprenant);
	}
	
	@RequestMapping(value="/{idApprenant}/delete",method = RequestMethod.DELETE) 
	
	public void deletApprenant(@PathVariable("idApprenant") Long idApprenant)
	{
		
		apprenantService.deletApprenantById(idApprenant);}
	
	
	}
