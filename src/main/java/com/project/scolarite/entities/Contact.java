package com.project.scolarite.entities;


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

public class Contact {
	
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	private Long idContact;
	
	private String email;
	 private Long numTel;
	 private String nomPrenom ;
	 private String message ;

}
