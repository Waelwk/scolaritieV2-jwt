package com.project.scolarite.restcontroller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.entities.Formateur;
import com.project.scolarite.entities.Role;
import com.project.scolarite.repos.FormateurRepository;
import com.project.scolarite.repos.UserRepository;

@RestController
@RequestMapping("/api/Formateur")
public class FormateurController {
	
	@Autowired
	  UserRepository UserRepository;
	@Autowired
	FormateurRepository FormateurRepository ;
	
	
	

    @PostMapping("/add")
    public Formateur createFormateur(MultipartFile file,
    		               String Specialite, 
                        String telFormateur ,
                             String NomFormateur, 
                              String PrenonFormateur, 
                              
                      String Password,
                    
                            String Email,
                          String AdresseFormateur) throws IOException {
    	Formateur Formateur= new Formateur();
    	Formateur.setNom(NomFormateur);
     long	TelFormateur=Long.valueOf(telFormateur);
     Formateur.setTel(TelFormateur);
  
   Formateur.setPrenom(PrenonFormateur);
   Formateur.setAdresse(AdresseFormateur);
   Formateur.setSpecialite( Specialite);
   Formateur.setFileType(file.getContentType());
   Formateur.setData(file.getBytes());
   Formateur.setCreatedAt(LocalDateTime.now());
   Formateur.setUpdatedAt(LocalDateTime.now());
   
   
   Formateur.setPassword(new BCryptPasswordEncoder().encode( Password ));
   
   Formateur.setRole(Role.FORMATEUR);
   Formateur.setEmail(Email);
        return  UserRepository.save(Formateur);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Formateur>> getAllImages() {
        List<Formateur>Formateur =FormateurRepository.findAll();
        return new ResponseEntity<>(Formateur, HttpStatus.OK);
    }
    @GetMapping("/{codeFormateur}")
    public ResponseEntity<Formateur> getFormateurbyId(@PathVariable Long codeDepartement) {
        Optional<Formateur> Formateur = FormateurRepository.findById(codeDepartement);
        if (Formateur.isPresent()) {
            return ResponseEntity.ok(Formateur.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{codeFormateur}")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable Long codeFormateur,
    		MultipartFile file,
            String Specialite, 
        String telFormateur ,
              String NomFormateur, 
               String PrenonFormateur, 
               String Password,
             String Email,
           String AdresseFormateur
           ) throws IOException {
        Optional<Formateur> optionalFormateur = FormateurRepository.findById(codeFormateur);
        if (optionalFormateur.isPresent()) {
        	Formateur Formateur = optionalFormateur.get();
        	Formateur.setNom(NomFormateur);
           long	TelFormateur=Long.valueOf(telFormateur);
            Formateur.setTel(TelFormateur);
       
         Formateur.setPrenom(PrenonFormateur);
         Formateur.setAdresse(AdresseFormateur);
         Formateur.setSpecialite( Specialite);
          
         
         if (Password!= null && !Password.isEmpty()) {

             Formateur.setPassword(new BCryptPasswordEncoder().encode( Password ));
             
         }
        
         if (file!=null) {
         Formateur.setFileType(file.getContentType());
         Formateur.setData(file.getBytes());}
         
         Formateur.setCreatedAt(LocalDateTime.now());
         Formateur.setUpdatedAt(LocalDateTime.now());
         
         
         Formateur.setRole(Role.FORMATEUR);
         Formateur.setEmail(Email);
            return ResponseEntity.ok( UserRepository.save(Formateur));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{codeFormateur}")
    public ResponseEntity<Void> deletFormateur(@PathVariable Long codeFormateur) {
    	FormateurRepository.deleteById(codeFormateur);
        return ResponseEntity.noContent().build();
    }
	
    
    
    @PutMapping("Archivee/{codeFormateur}")
    public ResponseEntity<Formateur> updateFormateur(@PathVariable Long codeFormateur
    		
           ) throws IOException {
        Optional<Formateur> optionalFormateur = FormateurRepository.findById(codeFormateur);
        if (optionalFormateur.isPresent()) {
        	Formateur Formateur = optionalFormateur.get();
        	Formateur.setArchive(true);
                      return ResponseEntity.ok( UserRepository.save(Formateur));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    
    @PutMapping("desArchivee/{codeFormateur}")
    public ResponseEntity<Formateur> desArchiveeFormateur(@PathVariable  Long codeFormateur
    		
           ) throws IOException {
        Optional<Formateur> optionalFormateur = FormateurRepository.findById(codeFormateur);
        if (optionalFormateur.isPresent()) {
        	Formateur Formateur = optionalFormateur.get();
        	Formateur.setArchive(false);
                      return ResponseEntity.ok( UserRepository.save(Formateur));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
	
	
}
