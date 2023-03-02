package com.project.scolarite.restcontroller;


import java.io.IOException;
import java.time.LocalDateTime;
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

import com.project.scolarite.entities.Etablissement;
import com.project.scolarite.repos.EtablissementRepository;
@RestController
@RequestMapping("/api/Etablissement")

public class EtablissementController {
   
	@Autowired
	
	private EtablissementRepository etablissementRepository;
	

    @PostMapping("/add")
    public Etablissement createEtablissement( MultipartFile file,
            
            String NomEtablissement, 
            String AbreviationEtablissement, 
           //long TelEtablissement,
          String EmailEtablissement,
         String RemarqueEtablissement) throws IOException {
    	Etablissement etablissement= new Etablissement();
    	etablissement.setNomEtablissement(NomEtablissement);
    	//etablissement.setTelEtablissement(TelEtablissement);
    	etablissement.setEmailEtablissement(EmailEtablissement);
    	etablissement.setRemarqueEtablissement(RemarqueEtablissement);
    	etablissement.setAbreviationEtablissement(AbreviationEtablissement);
    	etablissement.setFileType(file.getContentType());
    	etablissement.setData(file.getBytes());
    	etablissement.setCreatedAt(LocalDateTime.now());
    	etablissement.setUpdatedAt(LocalDateTime.now());
        return etablissementRepository.save(etablissement);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Etablissement>> getAllImages() {
        List<Etablissement> etablissement =etablissementRepository.findAll();
        return new ResponseEntity<>(etablissement, HttpStatus.OK);
    }
    @GetMapping("/{codeEtablissement}")
    public ResponseEntity<Etablissement> getEtablissement(@PathVariable Long codeEtablissement) {
        Optional<Etablissement> etablissement = etablissementRepository.findById(codeEtablissement);
        if (etablissement.isPresent()) {
            return ResponseEntity.ok(etablissement.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{codeEtablissement}")
    public ResponseEntity<Etablissement> updateEtablissement(@PathVariable Long codeEtablissement,
    	 MultipartFile file,
            
        String NomEtablissement, 
         String AbreviationEtablissement, 
          //  @RequestParam("TelEtablissement") Long TelEtablissement, 
          String EmailEtablissement,
             String RemarqueEtablissement) throws IOException {
        Optional<Etablissement> optionaletablissement = etablissementRepository.findById(codeEtablissement);
        if (optionaletablissement.isPresent()) {
            Etablissement etablissement = optionaletablissement.get();
            etablissement.setNomEtablissement(NomEtablissement);
        	//etablissement.setTelEtablissement(TelEtablissement);
        	etablissement.setEmailEtablissement(EmailEtablissement);
        	etablissement.setRemarqueEtablissement(RemarqueEtablissement);
        	etablissement.setAbreviationEtablissement(AbreviationEtablissement);
      if (file!=null) {
        	etablissement.setFileType(file.getContentType());
        	etablissement.setData(file.getBytes());}
     
        	etablissement.setCreatedAt(LocalDateTime.now());
        	etablissement.setUpdatedAt(LocalDateTime.now());
            return ResponseEntity.ok(etablissementRepository.save(etablissement));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codeEtablissement}")
    public ResponseEntity<Void> deletEtablissement(@PathVariable Long odeEtablissement) {
    	etablissementRepository.deleteById(odeEtablissement);
        return ResponseEntity.noContent().build();
    }
	

}
