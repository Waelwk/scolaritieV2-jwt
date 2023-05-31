package com.project.scolarite.entities;



import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.scolarite.services.SesionFormationServices;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
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
@Table(name = "Formateur")

@DiscriminatorValue("Formateur")
@PrimaryKeyJoinColumn(name="codeFormateur")

public class Formateur extends User {
	

	  

	    private String NomFormateur;
	    private String PrenonFormateur ;
	    private Long TelFormateur;
	   // private String EmailFormateur;
	    private String AdresseFormateur;
	    private String Specialite;
	 

	    private String fileType;

	    @Lob
	    private byte[] data;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;
	  @JsonIgnore
	    @OneToMany(mappedBy = "Formateur" ) 
	    private List<SesionDeFormation> SesionDeFormation;

	   
	    

}
