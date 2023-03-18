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

import com.project.scolarite.entities.Classe;
import com.project.scolarite.services.ClasseServices;


@RestController
@RequestMapping("/api/Classe")
@CrossOrigin
public class ClasseController {
@Autowired
ClasseServices classeServices ;
@GetMapping
public List<Classe> getAllClasse() {
	
	return classeServices.getAllClasse();
	
	}
  @GetMapping("/{idClasse}")
public Classe getClasseById(@PathVariable("idClasse") Long idClasse) {
	return classeServices.getClasse(idClasse);
}
  @PostMapping
	public Classe createClasse(@RequestBody Classe Classe) {
	return classeServices.saveClasse(Classe);
	}
  @PutMapping("/{idClasse}") 
	
	public Classe updateClasse(@RequestBody Classe Classe) {
		
	return classeServices.updateClasse(Classe);
	
	
	}
  @DeleteMapping("/{idClasse}/delete") 
	
	public void deletidClasse(@PathVariable("idClasse") Long idClasse)
	{
		
	  classeServices.deletClasseById(idClasse);
	  }
	
	
}

	
	
	


