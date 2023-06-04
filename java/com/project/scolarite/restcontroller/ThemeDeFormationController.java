package com.project.scolarite.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.scolarite.entities.ThemeDeFormation;
import com.project.scolarite.services.ThemeDeFormationService;

@RestController
@RequestMapping("/api/themeDeFormation")
public class ThemeDeFormationController {
	@Autowired
        ThemeDeFormationService ThemeDeFormationService;
	@GetMapping("/all")
	public List<ThemeDeFormation> getAllThemeDeFormation() {
		
	return  ThemeDeFormationService.getThemeDeFormation();
	}
	

	@PostMapping("/add")
	public ThemeDeFormation saveThemeDeFormation(@RequestBody ThemeDeFormation A) {
		return  ThemeDeFormationService.saveThemeDeFormation(A);
		
	}
	@GetMapping("/{idFormation}")
	public ThemeDeFormation getThemeDeFormation(Long idFormation ) {
		return  ThemeDeFormationService.getThemeDeFormation(idFormation) ;
		
		}
	
	
	@PutMapping("/{idFormation}")
	public ThemeDeFormation updateThemeDeFormation(@RequestBody ThemeDeFormation A) {
		return  ThemeDeFormationService.updateThemeDeFormation(A);
				}
	
	
	@DeleteMapping("/{idFormation}")
	public void deleThemeDeFormation(@PathVariable("idFormation") Long idFormation)
	{
		
		ThemeDeFormationService.deletThemeDeFormation(idFormation);
	
	
	}
	public void deletThemeDeFormation( ThemeDeFormation A )
	{
		
		ThemeDeFormationService.deletThemeDeFormation(A);
	
	
	}
	

}
