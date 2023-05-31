package com.project.scolarite.repos;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

  Optional<User> findByEmail(String email);

Optional<User> findById(Long id);

User findByVerificationToken(String verificationToken);


@Query("SELECT c FROM User c WHERE c.email = ?1")

public User findEmail(String email); 
 
public User findByResetPasswordToken(String token);
}
