package com.project.scolarite.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



@Getter
@Setter

@ToString

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Apprenant")
@DiscriminatorValue("Apprenant")
@PrimaryKeyJoinColumn(name="idApprenant")

public class  Apprenant extends   User  {


	
	
	 
	private String nomApprenant;
	private String prenomApprenant;
	private String sexeApprenant;
	private Date dateNaissanceApprenant;
	
//@Column(name = "emailApprenant", unique = true)
	 
	//private String emailApprenant;
	private Long telApprenant;
	private String adresseApprenant;
	@Enumerated(EnumType.STRING)
	private QualiteApprenant  qualiteApprenant;
	private String niveauApprenant;
	private boolean archiveApprenant=false;
	
	  @JsonIgnore

	@OneToMany(mappedBy ="Apprenant") 

	private List<Inscription> Insecription;


	
}
