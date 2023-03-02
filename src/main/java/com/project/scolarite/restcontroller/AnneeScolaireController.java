package com.project.scolarite.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.scolarite.entities.AnneeScolaire;

import com.project.scolarite.services.AnneeScolaireServices;

@RestController
@RequestMapping("/api/AnneeScolairee")
@CrossOrigin
public class AnneeScolaireController {
	@Autowired
	  AnneeScolaireServices anneeScolaireServices;
	
	
	@GetMapping("/all")
	public List<AnneeScolaire> getAllAnneeScolaire() {
		
	return anneeScolaireServices.getAllAnneeScolaire();
	}
	
	@PostMapping("/add")
	public AnneeScolaire saveAnneeScolaire(AnneeScolaire A) {
		return  anneeScolaireServices.saveAnneeScolaire(A);
		
	}

	@GetMapping("/{idAnneeScolaire}")
	public AnneeScolaire getAnneeScolaire(Long idAnneeScolaire) {
		return  anneeScolaireServices.getAnneeScolaire(idAnneeScolaire);
		}
		
	
	@PutMapping("/{idAnneeScolaire}")
	public AnneeScolaire updateAnneeScolaire(@RequestBody AnneeScolaire A) {
		return  anneeScolaireServices.updateAnneeScolaire(A);
				}
	
	
	@DeleteMapping("/{idAnneeScolaire}")
	public void deletAnneeScolaire(@PathVariable("idAnneeScolaire") Long idAnneeScolaire)
	{
		
		 anneeScolaireServices.deletAnneeScolaireById(idAnneeScolaire);
	
	
	}
	public void deletAnneeScolaire( AnneeScolaire A )
	{
		
		 anneeScolaireServices.deletAnneeScolaire(A);
	
	
	}
}
