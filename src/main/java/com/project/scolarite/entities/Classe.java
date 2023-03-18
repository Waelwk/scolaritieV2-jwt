package com.project.scolarite.entities;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Classe {

	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY) 
	 @Column(name = "idClasse", unique = true)
	private Long idClasse;
	 @Column(name = "nomClasse", unique = true )
	 
	private String nomClasse;
	 @ManyToOne
	 private Departement Departement;
	 @OneToMany(mappedBy = "Classe") 
	    private List<Apprenant> Apprenant;
}
