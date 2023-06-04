package com.project.scolarite.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.project.scolarite.entities.Admin;
@RepositoryRestResource(path = "rest")
public interface AdminRepo extends JpaRepository< Admin,Long> {

}
