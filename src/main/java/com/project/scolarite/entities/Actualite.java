package com.project.scolarite.entities;



import java.sql.Date;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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
@Table(name = "Actualite")
public class Actualite {
	
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long codeActualite;

	    private String titreActualite;
	    private String descriptionActualite ;
	    private Date dateActualite;
	   private LocalTime heureDebut;
	   
	 

	    private String fileType;

	    @Lob
	    private byte[] data;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;

	

}
