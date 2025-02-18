package com.example.service;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SailPointService {
  private final RestTemplate restTemplate = new RestTemplate();

  public ResponseEntity<String> syncUser(String username) {
    String sailPointUrl = "https://sailpoint-api.com/sync";

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    HttpEntity<String> request = new HttpEntity<>("{ \"username\": \"" + username + "\" }", headers);

    return restTemplate.exchange(sailPointUrl, HttpMethod.POST, request, String.class);
  }
}
