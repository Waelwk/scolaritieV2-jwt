package com.project.scolarite.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.scolarite.entities.Contact;
import com.project.scolarite.repos.ContactRepository;

import com.project.scolarite.services.ContactServices;


@RestController
@RequestMapping("/api/contact")
@CrossOrigin
public class ContactController {

	@Autowired
	ContactServices  contactServices  ;
	
	@GetMapping
	public List<Contact> getAllContact() {
		
		return contactServices.getAllContact();
		
		}
	  @GetMapping("/{idContact}")
	public Contact getContactyId(@PathVariable("idContact") Long idContact) {
		return contactServices.getContact(idContact);
	}
	  @PostMapping("/add")
		public Contact createContact(@RequestBody Contact Contact) {
		return contactServices.saveContact(Contact);
		}
	  @PutMapping("/{idContact}") 
		
		public Contact updateClasse(@RequestBody Contact Contact) {
			
		return contactServices.updateContact(Contact);
		
		
		}
	  @DeleteMapping("/{idContact}/delete") 
		
		public void deletidContact(@PathVariable("idContact") Long idContact)
		{
			
		  contactServices.deletContactById(idContact);
		  }
		
		
	}

