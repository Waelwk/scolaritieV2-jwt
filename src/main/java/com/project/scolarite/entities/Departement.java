package com.project.scolarite.entities;



import java.time.LocalDateTime;
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
@Table(name = "Departement")
public class Departement {
	
	     @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long codDepartement;

	    private String NomDepartement;
	    private String AbreviationDepartement ;
	    private Long TelDepartement;
	    private String EmailDepartement;
	    private String RemarqueDepartement;
	   
	 

	    private String fileType;

	    @Lob
	    private byte[] data;

	    @Column(name = "created_at")
	    private LocalDateTime createdAt;

	    @Column(name = "updated_at")
	    private LocalDateTime updatedAt;

}
