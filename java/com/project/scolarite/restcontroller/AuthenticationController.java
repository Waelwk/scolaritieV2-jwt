package com.project.scolarite.restcontroller;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.project.scolarite.entities.User;
import com.project.scolarite.repos.UserRepository;
import com.project.scolarite.security.auth.AuthenticationRequest;
import com.project.scolarite.security.auth.AuthenticationResponse;
import com.project.scolarite.security.auth.AuthenticationService;
import com.project.scolarite.security.auth.RegisterRequest;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @PostMapping("/registerUser")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody RegisterRequest request
  ) {
    return ResponseEntity.ok(service.register(request));
  }
  @PostMapping("/registerApprenant")
  public ResponseEntity<AuthenticationResponse> registerApprenant(
      @RequestBody RegisterRequest request
  ) {
	  
    return ResponseEntity.ok(service.registerApprenant(request));
  }
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }
  @GetMapping("/email/{email}")
  public Optional<User> getUserByEmail(@PathVariable String email) {
      return service.getUserByEmail(email);
  }
  
  @GetMapping("/id/{id}")
  public Optional<User> getUserById(@PathVariable Long id) {
      return service.getUserByID(id);
  }

}
