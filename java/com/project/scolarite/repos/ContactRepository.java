package com.project.scolarite.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scolarite.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
