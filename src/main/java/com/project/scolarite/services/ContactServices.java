package com.project.scolarite.services;

import java.util.List;


import com.project.scolarite.entities.Contact;

public interface ContactServices {
	
	
	
	Contact saveContact( Contact A);
	Contact updateContact(Contact A);
	void deletContact( Contact A);
	void deletContactById(Long idContact);
	Contact getContact(Long idContact);
	List<Contact> getAllContact();

}
