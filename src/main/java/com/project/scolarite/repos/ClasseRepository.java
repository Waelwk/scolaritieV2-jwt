package com.project.scolarite.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.scolarite.entities.Classe;
@RepositoryRestResource(path = "rest")
public interface ClasseRepository extends JpaRepository<Classe,Long> {
	//List<Classe> findByNomClasse(String nomClasse);
  //  List<Classe> findByNomProduitClasse(String nomClasse);
}
