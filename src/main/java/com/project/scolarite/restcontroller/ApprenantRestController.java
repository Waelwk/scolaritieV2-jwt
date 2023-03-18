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
import org.springframework.web.bind.annotation.RestController;

import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.services.ApprenantServices;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApprenantRestController {
	@Autowired
	ApprenantServices apprenantService;
	
	@GetMapping
	public List<Apprenant> getAllApprenant() {
		
	return apprenantService.getAllApprenant();
	}
	
	@GetMapping("/{idApprenant}")
	public Apprenant getApprenantById(@PathVariable("idApprenant") Long idApprenant) {
		return apprenantService.getApprenant(idApprenant);
	}
	
	@PostMapping
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
