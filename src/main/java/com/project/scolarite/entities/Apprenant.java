package com.project.scolarite.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Apprenant {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	 @Column(name = "idApprenant", unique = true)
	private Long idApprenant;
	 @Column(name = "codeApprenant", unique = true)
	private int codeApprenant;
	private String nomApprenant;
	private String prenomApprenant;
	private String sexeApprenant;
	private Date dateNaissanceApprenant;
	 @Column(name = "emailApprenant", unique = true)
	private String emailApprenant;
	private Long telApprenant;
	private String adresseApprenant;
	private boolean archiveApprenant=false;
	
}
