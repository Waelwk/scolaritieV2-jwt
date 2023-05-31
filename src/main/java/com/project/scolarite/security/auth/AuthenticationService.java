package com.project.scolarite.security.auth;

import lombok.experimental.SuperBuilder;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.scolarite.entities.Apprenant;
import com.project.scolarite.entities.Role;
import com.project.scolarite.entities.User;
import com.project.scolarite.repos.UserRepository;
import com.project.scolarite.security.config.JwtService;

@Service
@RequiredArgsConstructor
public  class AuthenticationService {
  private final UserRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
	 if(repository.findByEmail(request.getEmail()) != null) ;
    var user = User.builder().userame(request.getUserame())
    
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.ADMIN)
        .build();
    
    repository.save(user);
    
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  
	 
  }

  public AuthenticationResponse registerApprenant(RegisterRequest request) {
	 if(repository.findByEmail(request.getEmail()) != null) ;
    var user = User.builder()
        .userame(request.getUserame())
    
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.APPRENANT)
        
        .build();
    
    repository.save(user);
    
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  
	 
  }
  
  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmail(),
            request.getPassword()
        )
    );
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
   
    
    var jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }
  
  public Optional <User> getUserByEmail(String email) {
      return repository.findByEmail(email);
  }
  public Optional <User> getUserByID(Long Id) {
      return repository.findById(Id);
  }
}
