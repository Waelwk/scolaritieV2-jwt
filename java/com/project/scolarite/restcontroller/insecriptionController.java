package com.project.scolarite.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.entities.Inscription;
import com.project.scolarite.entities.SesionDeFormation;
import com.project.scolarite.entities.ThemeDeFormation;
import com.project.scolarite.repos.InsecriptionRepository;
import com.project.scolarite.repos.SesionFormationRepository;
import com.project.scolarite.repos.ApprenantRepository;
import com.project.scolarite.services.InsecriptionServices;
import com.project.scolarite.services.SesionFormationServices;
import com.project.scolarite.services.ThemeDeFormationService;
import org.springframework.web.multipart.MultipartFile;
@RestController
@RequestMapping("/api/inscription")
@CrossOrigin(origins = "*")
public class insecriptionController {
	@Autowired
	InsecriptionServices insecriptionServices;
	
	@Autowired
	SesionFormationServices SesionFormationServices;
	
	
	@Autowired
	InsecriptionRepository InsecriptionRepository;
	
	@Autowired
	SesionDeFormationControllers SesionFormationCon;
	
	@Autowired
	ApprenantRestController ApprenantControlers;
	
@GetMapping("/all")
public List<Inscription> getAllInsecription() {
	

return  insecriptionServices.getAllInsecription();
}


/*@PostMapping(value="/add", consumes = "application/json")
public List<Inscription> saveInsecription(@RequestBody List<Apprenant> apprenants) {
    List<Inscription> inscriptions = new ArrayList<>();
    for (Apprenant apprenant : apprenants) {
        cc
        inscription.setApprenant(apprenant);
        inscriptions.add(inscription);
    }
    return InsecriptionRepository.saveAll(inscriptions);
}*/




@PostMapping(path = "/add", consumes = { MediaType.APPLICATION_JSON_VALUE })
public ResponseEntity<?> saveInscription(@RequestParam("idSessionFormation") Long idSessionFormation,
        @RequestParam("apprenant") Long apprenant) {

    Inscription inscription = new Inscription();
    SesionDeFormation sessionFormation = SesionFormationCon.getSesionDeFormation(idSessionFormation);
    Apprenant apprenantObj = ApprenantControlers.getApprenantById(apprenant);

    // Check if the apprenant is already inscribed in the session
    boolean isAlreadyInscribed = false;
    for (Inscription existingInscription : sessionFormation.getInsecription()) {
        if (existingInscription.getApprenant().getId().equals(apprenant)) {
            isAlreadyInscribed = true;
            break;
        }
    }

    if (isAlreadyInscribed) {
        // Apprenant is already inscribed
        return ResponseEntity.badRequest().body("You are already inscribed");
    }

    inscription.setSessionFormation(sessionFormation);
    inscription.setApprenant(apprenantObj);

    InsecriptionRepository.save(inscription);

    return ResponseEntity.ok(inscription);
}


@GetMapping("/{CodeInscription}")
public Inscription getInsecription(@PathVariable Long CodeInscription) {
	return  insecriptionServices.getInsecription(CodeInscription) ;
	
	}


@PutMapping("/{CodeInscription}")
public Inscription updateInsecription(@RequestBody Inscription A) {
	return  insecriptionServices.updateInsecription(A);
			}


@DeleteMapping("/{CodeInscription}")
public void deleTInsecriptionById (@PathVariable("CodeInscription") Long CodeInscription)
{
	
	insecriptionServices.deletInsecriptionById (CodeInscription);


}
public void deleteInsecription ( Inscription  A )
{
	
	insecriptionServices.deletInsecription (A);


}


}

	
	
	
	


