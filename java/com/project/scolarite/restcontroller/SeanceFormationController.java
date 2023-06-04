package com.project.scolarite.restcontroller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.scolarite.entities.Formateur;
import com.project.scolarite.entities.Inscription;
import com.project.scolarite.entities.SeanceFormation;
import com.project.scolarite.entities.SesionDeFormation;
import com.project.scolarite.entities.ThemeDeFormation;
import com.project.scolarite.repos.InsecriptionRepository;
import com.project.scolarite.repos.SeanceFormationRepository;
import com.project.scolarite.services.SeanceFormationService;

@RestController
@RequestMapping("/api/SeanceFormation")
@CrossOrigin
public class SeanceFormationController {
	@Autowired
	SeanceFormationService seanceFormationService;
	@Autowired
	SesionDeFormationControllers SesionFormationCon;
	@Autowired
	
	SeanceFormationRepository SeanceFormationRepository;
	@Autowired
	InsecriptionRepository insecriptionRepository;
	
	
	public SeanceFormationController(	SeanceFormationRepository SeanceFormationRepository,
			InsecriptionRepository insecriptionRepository) {
this.SeanceFormationRepository = SeanceFormationRepository;
this.insecriptionRepository = insecriptionRepository;
}
	@GetMapping("/alll")
	 public ResponseEntity<List<SeanceFormation>> getAllTutorials() {
		    List<SeanceFormation> tutorials = new ArrayList<SeanceFormation>();

		   
		    	SeanceFormationRepository.findAll().forEach(tutorials::add);
		    

		    return new ResponseEntity<>(tutorials, HttpStatus.OK);
		  }

	@GetMapping("/all")
	public List<SeanceFormation> getAllSeanceFormation() {
		List<SeanceFormation> aa = SeanceFormationRepository.findAll();

		return  aa;
		
		
		} 
	
	@PostMapping("/seances/{seanceId}/inscriptions")
	public SeanceFormation addInscriptionsToSeance(
	        @PathVariable("seanceId") Long seanceId,
	        @RequestBody List<Long> inscriptionIds) {

	    SeanceFormation seance = SeanceFormationRepository.findById(seanceId).orElse(null);

	    if (seance != null) {
	        List<Inscription> inscriptions = insecriptionRepository.findAllById(inscriptionIds);

	        for (Inscription inscription : inscriptions) {
	            inscription.getSeanceFormation().add(seance);
	            seance.getInscription().add(inscription);
	        }

	        insecriptionRepository.saveAll(inscriptions);
	        SeanceFormationRepository.save(seance);

	        return seance;
	    } else {
	        // Handle case when seance is not found
	        throw new IllegalArgumentException("Seance not found");
	    }
	}

	@PostMapping("/add")
	public SeanceFormation createSesionDeFormation(
	        MultipartFile file,
	        Long idSessionFormation,
	        LocalTime heureDebut,
	        Date date,
	        String local,
	        String nbrHeures,
	        String contenu
	) throws IOException {
	    SesionDeFormation sessionFormation = SesionFormationCon.getSesionDeFormation(idSessionFormation);
	    
	    SeanceFormation seanceFormation = new SeanceFormation();
	    seanceFormation.setDate(date);
	    seanceFormation.setContenu(contenu);
	    seanceFormation.setLocal(local);
	    
	    seanceFormation.setHeureDebut(heureDebut);
	    
	    long nbrHeuresValue = Long.valueOf(nbrHeures);
	    seanceFormation.setNbrHeures(nbrHeuresValue);
	    
	    seanceFormation.setSessionFormation(sessionFormation);
	    seanceFormation.setFileType(file.getContentType());
	    seanceFormation.setData(file.getBytes());
	    seanceFormation.setCreatedAt(LocalDateTime.now());
	    seanceFormation.setUpdatedAt(LocalDateTime.now());
	    
	
	    
	    return SeanceFormationRepository.save(seanceFormation);
	}
	
	@GetMapping("/{IdSeanceFormation}")
    public SeanceFormation getSeanceFormation(@PathVariable Long IdSeanceFormation) {
        Optional<SeanceFormation> SeanceFormation= SeanceFormationRepository.findById(IdSeanceFormation);
        
            return SeanceFormation.get();
        
     
    }
	
	@PutMapping("/{IdSeanceFormation}")
    public ResponseEntity<SeanceFormation> updateSesionDeFormation(@PathVariable Long IdSeanceFormation,
    		  MultipartFile file,
  	        Long idSessionFormation,
  	        LocalTime heureDebut,
  	        Date date,
  	        String local,
  	        String nbrHeures,
  	        String contenu
) throws IOException, ParseException {
	SesionDeFormation sessionFormation = SesionFormationCon.getSesionDeFormation(idSessionFormation);
        Optional<SeanceFormation> opSeanceFormation = SeanceFormationRepository.findById(IdSeanceFormation);
        if (opSeanceFormation.isPresent()) {
        	
        	SeanceFormation SeanceFormation = opSeanceFormation.get();
        	SeanceFormation.setDate(date);
    		SeanceFormation.setContenu(contenu);
    		
    		SeanceFormation.setLocal(local);
    	
    		long	NbrHeures=Long.valueOf(nbrHeures);
    		SeanceFormation.setNbrHeures(NbrHeures);
    	
    	   	SeanceFormation.setSessionFormation(sessionFormation );    	   	 
    		SeanceFormation.setHeureDebut(heureDebut);
    		
    		
    		 if (file!=null) {
    		SeanceFormation.setFileType(file.getContentType());
    		SeanceFormation.setData(file.getBytes());
    		SeanceFormation.setCreatedAt(LocalDateTime.now());
    		SeanceFormation.setUpdatedAt(LocalDateTime.now());}
    		
      
      
            return ResponseEntity.ok(SeanceFormationRepository.save(SeanceFormation));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    

@DeleteMapping("/{IdSeanceFormation}")

public void deletSeanceFormation(@PathVariable("IdSeanceFormation") Long IdSeanceFormation)
{
	
	seanceFormationService.deletSeanceFormationById(IdSeanceFormation);


}

	
	
	
}
