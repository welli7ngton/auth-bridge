package com.example.service;

import org.springframework.ldap.core.LdapTemplate;
import org.springframework.stereotype.Service;

@Service
public class LdapAuthService {
  private final LdapTemplate ldapTemplate;

  public LdapAuthService(LdapTemplate ldapTemplate) {
    this.ldapTemplate = ldapTemplate;
  }

  public boolean authenticate(String username, String password) {
    return ldapTemplate.authenticate(
        "ou=users,dc=example,dc=com",
        "(uuid" + username + ")",
        password);
  }
}
