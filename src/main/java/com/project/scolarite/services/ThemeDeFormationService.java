package com.project.scolarite.services;

import java.util.List;


import com.project.scolarite.entities.ThemeDeFormation;

public interface ThemeDeFormationService {
	ThemeDeFormation saveThemeDeFormation( ThemeDeFormation A);
	ThemeDeFormation updateThemeDeFormation( ThemeDeFormation A);
	void deletThemeDeFormation( ThemeDeFormation A);
	void deletThemeDeFormation(Long idThemeDeFormation);
	ThemeDeFormation getThemeDeFormation(Long idThemeDeFormation);
	List<ThemeDeFormation> getThemeDeFormation();


}
