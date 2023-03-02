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
public class AnneeScolaire {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	 @Column(name = "idAnneeScolaire", unique = true)
	private Long idAnneeScolaire;
	 @Column(name = "AnneeScolaire", unique = true)
	private Date Annee;
}
