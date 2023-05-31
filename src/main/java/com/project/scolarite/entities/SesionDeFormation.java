package com.project.scolarite.entities;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "SesionFormation")
public class SesionDeFormation {
    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idSessionFormation;
    @Enumerated(EnumType.STRING)
private  TypeFormation TypeFormation ;
    
private  String LocalFormation ;
private  String Description ;
private  Date DateDebut ;
private  Date DateFin ;
private  Long NbrHeures;

private String fileType;

@Lob
private byte[] data;

@Column(name = "created_at")
private LocalDateTime createdAt;

@Column(name = "updated_at")
private LocalDateTime updatedAt;

@ManyToOne 
private    Formateur  Formateur;

@ManyToOne 

private ThemeDeFormation ThemeDeFormation;

@JsonIgnore
@OneToMany(mappedBy = "SessionFormation") 
private List<Inscription> Insecription ;
@JsonIgnore

@OneToMany(mappedBy = "SessionFormation" )
private List<SeanceFormation> SeanceFormation ;
}
