package com.project.scolarite.repos;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.scolarite.entities.Inscription;


public interface InsecriptionRepository extends JpaRepository< Inscription, Long> {
	
}
