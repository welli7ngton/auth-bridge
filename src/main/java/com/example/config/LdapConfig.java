package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.ldap.repository.config.EnableLdapRepositories;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableLdapRepositories
public class LdapConfig {

  @Value("${ldap.urls}")
  private String ldapUrls;

  @Value("${ldap.base.dn}")
  private String ldapBaseDn;

  @Value("${ldap.username}")
  private String ldapUsername;

  @Value("${ldap.password}")
  private String ldapPassword;

  protected String[] getBasePackages() {
    return new String[] { "com.example.identitymanager" };
  }

  @Bean
  public LdapContextSource contextSource() {
    LdapContextSource contextSource = new LdapContextSource();
    contextSource.setUrl(ldapUrls);
    contextSource.setBase(ldapBaseDn);
    contextSource.setUserDn(ldapUsername);
    contextSource.setPassword(ldapPassword);

    return contextSource;
  }
}
