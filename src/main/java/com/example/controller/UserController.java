package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.LdapAuthService;
import com.example.dto.LoginRequest;

@RestController
@RequestMapping
public class UserController {
  private final LdapAuthService ldapAuthService;

  public UserController(LdapAuthService ldapAuthService) {
    this.ldapAuthService = ldapAuthService;

  }

  @PostMapping
  public ResponseEntity<?> login(@RequestBody LoginRequest request) {
    boolean isAuthenticated = ldapAuthService.authenticate(request.getUsername(), request.getPassword());
    if (isAuthenticated) {
      return ResponseEntity.ok("Login successful");
    }
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
  }
}
