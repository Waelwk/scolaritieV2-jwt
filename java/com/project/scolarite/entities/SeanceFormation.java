package com.project.scolarite.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "SeanceFormation")
public class SeanceFormation {
	
	
	    @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private Long IdSeanceFormation ;
	    
	   public Date Date ;
	   public String Local ;
	   private  LocalTime heureDebut;
	   private  Long NbrHeures;
private String Contenu ;

private String fileType;

@Lob
private byte[] data;

@Column(name = "created_at")
private LocalDateTime createdAt;

@Column(name = "updated_at")
private LocalDateTime updatedAt;


@ManyToOne 
private SesionDeFormation SessionFormation ; 
@Getter
@Setter


@ManyToMany (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
@JoinTable(name = "presence")

private List < Inscription > Inscription = new ArrayList<> ();
	

}
