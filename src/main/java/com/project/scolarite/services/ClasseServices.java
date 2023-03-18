package com.project.scolarite.services;

import java.util.List;


import com.project.scolarite.entities.Classe;

public interface ClasseServices {
	 Classe saveClasse(  Classe A);
	 Classe updateClasse( Classe A);
	void deletClasse( Classe A);
	void deletClasseById(Long idClasse);
	Classe getClasse(Long idClasse);
	List<Classe> getAllClasse();

}
