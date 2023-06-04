package com.project.scolarite.restcontroller;


import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.scolarite.entities.Actualite;
import com.project.scolarite.entities.Etablissement;
import com.project.scolarite.repos.ActualiteRepository;
import com.project.scolarite.repos.EtablissementRepository;
@RestController
@RequestMapping("/api/actualite")

public class ActualiteController {
   
	@Autowired
	private ActualiteRepository actualiteRepository;
	

    @PostMapping("/add")
    public Actualite createActualite( MultipartFile file,
            
    		  String titreActualite,
     String descriptionActualite ,
     Date dateActualite,
     LocalTime  heureDebut
         ) throws IOException, ParseException {
    	Actualite actualite= new Actualite();
    	
    	actualite.setTitreActualite(titreActualite);
    	
    	actualite.setDescriptionActualite(descriptionActualite);
    	actualite.setHeureDebut(heureDebut);
    	
    
    	
    	 /*DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
    	 java.util.Date DateActualite =  format.parse(dateActualite);
        actualite.setDateActualite((Date) DateActualite);*/
    	
    	actualite.setDateActualite(dateActualite);
    	actualite.setFileType(file.getContentType());
    	actualite.setData(file.getBytes());
    	actualite.setCreatedAt(LocalDateTime.now());
    	actualite.setUpdatedAt(LocalDateTime.now());
        return actualiteRepository.save(actualite);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Actualite>> getAllImages() {
        List<Actualite> actualite =actualiteRepository.findAll();
        return new ResponseEntity<>(actualite, HttpStatus.OK);
    }
    @GetMapping("/{codeActualite}")
    public ResponseEntity<Actualite> getActualite(@PathVariable Long codeActualite) {
        Optional<Actualite> actualite = actualiteRepository.findById(codeActualite);
        if (actualite.isPresent()) {
            return ResponseEntity.ok(actualite.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{codeActualite}")
    public ResponseEntity<Actualite> updateEtablissement(@PathVariable Long codeActualite,
    	 MultipartFile file,
            
    	 String titreActualite,
         String descriptionActualite ,
         LocalTime  heureDebut,
         Date dateActualite) throws IOException, ParseException {
        Optional<Actualite> optionalactualite = actualiteRepository.findById(codeActualite);
        if (optionalactualite.isPresent()) {
        	Actualite actualite = optionalactualite.get();
        	actualite.setTitreActualite(titreActualite);
           actualite.setDescriptionActualite(descriptionActualite);
  
          actualite.setDateActualite(dateActualite);
          actualite.setHeureDebut(heureDebut);
      if (file!=null) {
    	  actualite.setFileType(file.getContentType());
    	  actualite.setData(file.getBytes());}
     
      actualite.setCreatedAt(LocalDateTime.now());
      actualite.setUpdatedAt(LocalDateTime.now());
            return ResponseEntity.ok(actualiteRepository.save(actualite));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @DeleteMapping("/{codeActualite}")
    public ResponseEntity<Void> deletEtablissement(@PathVariable Long codeActualite) {
    	actualiteRepository.deleteById(codeActualite);
        return ResponseEntity.noContent().build();
    }
	

}
