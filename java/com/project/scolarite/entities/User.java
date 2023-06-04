package com.project.scolarite.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

import java.sql.Date;
import java.time.Instant;
import java.util.Collection;
import java.util.List;

import org.springframework.security.config.core.GrantedAuthorityDefaults;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Data

@NoArgsConstructor
@AllArgsConstructor
@Table(name = "_user")
@Entity
@Builder

@Inheritance(strategy = InheritanceType.JOINED)

@DiscriminatorColumn(name="Type",length=12)
public   class User implements UserDetails {

  @Id
  @GeneratedValue
  
  private Long id;
  private String userame;
  
  @Column(name = "verification_code", length = 64)
  private boolean verified;
  private String verificationToken;

  private Instant tokenExpirationTime;

  
  @JoinColumn(nullable = false)
  @Column(name = "email", unique = true, length = 115)
  private String email;
  private String password;

  @Enumerated(EnumType.STRING)
  private Role role;
  
  
  
  
  private String resetPasswordToken;
  
  
  
  @Override

  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }


}
