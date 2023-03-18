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

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.scolarite.entities.Departement;

import com.project.scolarite.repos.DepartementRepository;

@RestController
@RequestMapping("/api/Departement")
public class DepartementController {
	
	
	@Autowired
	DepartementRepository departementRepository ;
	
	
	

    @PostMapping("/add")
    public Departement createDepartement(MultipartFile file,
                         
                             String NomDepartement, 
                              String AbreviationDepartement, 
                           String telDepartement, 
                            String EmailDepartement,
                          String RemarqueDepartement) throws IOException {
    	Departement departement= new Departement();
    	departement.setNomDepartement(NomDepartement);
      long	TelDepartement =Long.valueOf(telDepartement);
   departement.setTelDepartement(TelDepartement);
    	departement.setEmailDepartement(EmailDepartement);
    	departement.setRemarqueDepartement(RemarqueDepartement);
    	departement.setAbreviationDepartement(AbreviationDepartement);
    	departement.setFileType(file.getContentType());
    	departement.setData(file.getBytes());
    	departement.setCreatedAt(LocalDateTime.now());
    	departement.setUpdatedAt(LocalDateTime.now());
        return departementRepository.save(departement);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Departement>> getAllImages() {
        List<Departement>departement =departementRepository.findAll();
        return new ResponseEntity<>(departement, HttpStatus.OK);
    }
    @GetMapping("/{codeDepartement}")
    public ResponseEntity<Departement> getDepartement(@PathVariable Long codeDepartement) {
        Optional<Departement> departement = departementRepository.findById(codeDepartement);
        if (departement.isPresent()) {
            return ResponseEntity.ok(departement.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{codeDepartement}")
    public ResponseEntity<Departement> updateDepartement(@PathVariable Long codeDepartement,
    		MultipartFile file,
            
             String NomDepartement, 
           String AbreviationDepartement, 
           String telDepartement, 
         String EmailDepartement,
          String RemarqueDepartement) throws IOException {
        Optional<Departement> optionaldepartement = departementRepository.findById(codeDepartement);
        if (optionaldepartement.isPresent()) {
        	Departement departement = optionaldepartement.get();
        	departement.setNomDepartement(NomDepartement);
            long	TelDepartement =Long.valueOf(telDepartement);
            departement.setTelDepartement(TelDepartement);
        	departement.setEmailDepartement(EmailDepartement);
        	departement.setRemarqueDepartement(RemarqueDepartement);
        	departement.setAbreviationDepartement(AbreviationDepartement);
        	 if (file!=null) {
        	departement.setFileType(file.getContentType());
        	departement.setData(file.getBytes());}
        	departement.setCreatedAt(LocalDateTime.now());
        	departement.setUpdatedAt(LocalDateTime.now());
            return ResponseEntity.ok(departementRepository.save(departement));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codeDepartement}")
    public ResponseEntity<Void> deletDepartement(@PathVariable Long codeDepartement) {
    	departementRepository.deleteById(codeDepartement);
        return ResponseEntity.noContent().build();
    }
	

}
