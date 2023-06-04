package com.project.scolarite.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Data


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Inscription")
public class Inscription {

	 @Id
	    
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long CodeInscription ;
	    
	 @ManyToOne  
	  private Apprenant Apprenant ;
	 

	  @ManyToOne 
	 private SesionDeFormation SessionFormation ; 
	  
	  @ManyToMany(fetch = FetchType.LAZY,
		      cascade = {     CascadeType.ALL,
		          CascadeType.PERSIST,
		          CascadeType.MERGE
		      },
		      mappedBy = "Inscription")
	  @JsonIgnore
		  private List<SeanceFormation> SeanceFormation = new ArrayList<>();
	  
	 
}
