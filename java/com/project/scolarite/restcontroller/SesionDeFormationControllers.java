package com.project.scolarite.restcontroller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.scolarite.entities.Actualite;

import com.project.scolarite.entities.Etablissement;
import com.project.scolarite.entities.Formateur;
import com.project.scolarite.entities.SesionDeFormation;
import com.project.scolarite.entities.ThemeDeFormation;
import com.project.scolarite.entities.TypeFormation;
import com.project.scolarite.repos.SesionFormationRepository;
import com.project.scolarite.services.SesionFormationServices;

@RestController
@RequestMapping("/api/sessionDeFormation")
@CrossOrigin
public class SesionDeFormationControllers {
	
	@Autowired
	SesionFormationRepository SesionFormationRepository;
	@Autowired
	SesionFormationServices sesionFormationServices;
	
	
	@GetMapping("/all")
	public List<SesionDeFormation> getAllSesionDeFormation() {
		
		return sesionFormationServices.getAllSesionDeFormation();
		
		
		}
	
/*
    @PostMapping("/addImg")
    public SesionDeFormation createimgSesionDeFormation( MultipartFile file
            
          ) throws IOException {
    	SesionDeFormation SesionDeFormation= new SesionDeFormation();
    	
    	SesionDeFormation.setFileType(file.getContentType());
    	SesionDeFormation.setData(file.getBytes());
    	SesionDeFormation.setCreatedAt(LocalDateTime.now());
    	SesionDeFormation.setUpdatedAt(LocalDateTime.now());
        return sesionFormationRepository.save(SesionDeFormation);
    }*/
    

	
	
	/*@PostMapping("/add")
	public SesionDeFormation saveSesionDeFormation( @RequestBody SesionDeFormation A) {
		return sesionFormationServices.saveSesionDeFormation(A);
		
	}*/
	
	@PostMapping("/add")
    public SesionDeFormation createSesionDeFormation( MultipartFile file,
    		 String TypeFormation ,
          
            String LocalFormation, 
     String nbrHeures,
           Date DateDebut,
           Date DateFin,
           Formateur  formateur,
           ThemeDeFormation themeDeFormation,
         String Description) throws IOException {
		
    	SesionDeFormation SesionDeFormation= new SesionDeFormation();
    	SesionDeFormation.setDateDebut(DateDebut);
    	SesionDeFormation.setDateFin(DateFin);
    	SesionDeFormation.setDescription(Description);
    	if(TypeFormation.equals("EnLigne")) {
    		
    		
    	
    	SesionDeFormation.setTypeFormation(com.project.scolarite.entities.TypeFormation.EnLigne);
    	}
    	
    	else {SesionDeFormation.setTypeFormation(com.project.scolarite.entities.TypeFormation.Présentiel);
    		
    	}
    	
    	
    	SesionDeFormation.setLocalFormation(LocalFormation);
    	
    	SesionDeFormation.setFormateur(formateur);
    	
    	SesionDeFormation.setThemeDeFormation(themeDeFormation);
    	
    	long	NbrHeures=Long.valueOf(nbrHeures);
    	 
        SesionDeFormation.setNbrHeures(NbrHeures);
    	
    	SesionDeFormation.setFileType(file.getContentType());
    	SesionDeFormation.setData(file.getBytes());
    	SesionDeFormation.setCreatedAt(LocalDateTime.now());
    	SesionDeFormation.setUpdatedAt(LocalDateTime.now());
        return SesionFormationRepository.save(SesionDeFormation);
    }

	
	/*@GetMapping("/byid/{idSessionFormation}")
	public SesionDeFormation getSesionDeFormation(Long iSesionDeFormation) {
		return  sesionFormationServices.getSesionDeFormation(idSessionFormation);
		}
		*/
	
	   @GetMapping("/{idSessionFormation}")
	    public SesionDeFormation getSesionDeFormation(@PathVariable Long idSessionFormation) {
	        Optional<SesionDeFormation> SesionDeFormation= SesionFormationRepository.findById(idSessionFormation);
	        
	            return SesionDeFormation.get();
	        
	     
	    }
	   
	/*@PutMapping("/{idSessionFormation}")
	public SesionDeFormation updateSesionDeFormation(@RequestBody SesionDeFormation A) {
		return sesionFormationServices.updateSesionDeFormation(A);
		
				}*/
	
	 @PutMapping("/{idSessionFormation}")
	    public ResponseEntity<SesionDeFormation> updateSesionDeFormation(@PathVariable Long idSessionFormation,
	    		MultipartFile file,
	    		 String typeFormation ,
	          
	            String LocalFormation, 
	    // String nbrHeures,
	           Date DateDebut,
	           Date DateFin,
	           Formateur  formateur,
	           ThemeDeFormation themeDeFormation,
	         String Description) throws IOException, ParseException {
	        Optional<SesionDeFormation> opSesionDeFormation = SesionFormationRepository.findById(idSessionFormation);
	        if (opSesionDeFormation.isPresent()) {
	        	SesionDeFormation SesionDeFormation = opSesionDeFormation.get();
	        	SesionDeFormation.setDateDebut(DateDebut);
	        	SesionDeFormation.setDateFin(DateFin);
	        	SesionDeFormation.setDescription(Description);
	        	
	        	if(typeFormation.equals("EnLigne")) {
	        		
	        		
	            	
	            	SesionDeFormation.setTypeFormation(com.project.scolarite.entities.TypeFormation.EnLigne);
	            	}
	            	
	            	else {SesionDeFormation.setTypeFormation(com.project.scolarite.entities.TypeFormation.Présentiel);
	            		
	            	}
	        	SesionDeFormation.setLocalFormation(LocalFormation);
	        	
	        	SesionDeFormation.setFormateur(formateur);
	        	
	        	SesionDeFormation.setThemeDeFormation(themeDeFormation);
	        	
	        	//long	NbrHeures=Long.valueOf(nbrHeures);
	        	 
	            //SesionDeFormation.setNbrHeures(NbrHeures);
	           
	      if (file!=null) {
	    	  SesionDeFormation.setFileType(file.getContentType());
	      	SesionDeFormation.setData(file.getBytes());
	      	SesionDeFormation.setCreatedAt(LocalDateTime.now());
	      	SesionDeFormation.setUpdatedAt(LocalDateTime.now());}
	      
	            return ResponseEntity.ok(SesionFormationRepository.save(SesionDeFormation));
	        } else {
	            return ResponseEntity.notFound().build();
	        }
	    }
	    
	    
	
	@DeleteMapping("/{idSessionFormation}")
	public void deletSesionDeFormation(@PathVariable("idSessionFormation") Long idSessionFormation)
	{
		
		sesionFormationServices.deletSesionDeFormationById(idSessionFormation);
	
	
	}


}
