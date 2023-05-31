package com.project.scolarite.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.scolarite.entities.Contact;
import com.project.scolarite.repos.ContactRepository;
@Service
public class ContactServicesImp implements ContactServices {
@Autowired
ContactRepository contactRepository;
	@Override
	public Contact saveContact(Contact A) {
		// TODO Auto-generated method stub
		return contactRepository.save(A);
	}

	@Override
	public Contact updateContact(Contact A) {
		// TODO Auto-generated method stub
		return contactRepository.save(A);
	}

	@Override
	public void deletContact(Contact A) {
 contactRepository.delete(A);

	}

	@Override
	public void deletContactById(Long idContact) {
		 contactRepository.deleteById(idContact);

	}

	@Override
	public Contact getContact(Long idContact) {
		// TODO Auto-generated method stub
		return	contactRepository.findById(idContact).get();
	}

	@Override
	public List<Contact> getAllContact() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}

}
