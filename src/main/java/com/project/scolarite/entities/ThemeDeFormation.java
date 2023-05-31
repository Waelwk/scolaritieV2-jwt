package com.project.scolarite.entities;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.scolarite.services.SesionFormationServices;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "ThemeDeFormation")
public class ThemeDeFormation {

	
		
		     @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long idFormation ;
		     @Column(name = "nomFormation", unique = true)
		    private String nomFormation;
		    private String abrevation;
		    private String description;
		  @JsonIgnore
		   @OneToMany(mappedBy = "ThemeDeFormation" ,cascade = CascadeType.ALL) 
		   private List<SesionDeFormation> SesionDeFormation;
		    }
