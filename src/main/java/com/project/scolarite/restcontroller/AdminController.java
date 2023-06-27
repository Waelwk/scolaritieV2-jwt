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

import com.project.scolarite.entities.Admin;
import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.repos.UserRepository;
import com.project.scolarite.services.AdminServises;
import com.project.scolarite.services.ApprenantServices;
import com.project.scolarite.services.EmailVerificationService;
@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {
	
	
	
	@Autowired
	AdminServises AdminService;
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
	
	
	public List<Admin> getAllAdmin() {
		
	return AdminService.getAllAdmin();
	}
	
	@GetMapping("/{idAdmin}")
	public Admin getAdminById(@PathVariable("idAdmin") Long idApprenant) {
		return AdminService.getAdmin(idApprenant);
	}
	
	@PostMapping("/add") 
	public Admin createAdmin(@RequestBody Admin Admin) {
	
	
		return AdminService.saveAdmin(Admin);
	}

	@PutMapping("/{idAdmin}") 
	
	public Admin updateApprenantt(@RequestBody Admin Admin) {
		
	return AdminService.updateAdmin(Admin);
	
	
	}
	
	@RequestMapping(value="/{idAdmin}/patch",method = RequestMethod.PUT)
	public Admin patchAdmintt(@RequestBody Admin Admin) {
		
		Admin.setArchive(true);
	return AdminService.updateAdmin(Admin);
	}
	
	@RequestMapping(value="/{idApprenant}/delete",method = RequestMethod.DELETE) 
	
	public void deletAdmin(@PathVariable("idAdmin") Long idAdmin)
	{
		
		AdminService.deletAdminById(idAdmin);}
	
	
	
	



@RequestMapping(value="/{idApprenant}/patchArch",method = RequestMethod.PUT)
public 	Admin patchArchAdmintt(@RequestBody 	Admin Admin ) {
	
	Admin.setArchive(false);
return	AdminService.updateAdmin(	Admin);
}
}
