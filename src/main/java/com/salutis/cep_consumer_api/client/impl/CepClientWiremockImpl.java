package com.salutis.cep_consumer_api.client.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.salutis.cep_consumer_api.client.CepClient;
import com.salutis.cep_consumer_api.dto.CepResponseDTO;

@Component
public class CepClientWiremockImpl implements CepClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String API_URL = "http://localhost:8081/api/cep"; // Ex: mockado com Wiremock

    @Override
    public CepResponseDTO buscarCep(String cep) {
        String url = UriComponentsBuilder.fromHttpUrl(API_URL)
                .pathSegment(cep)
                .toUriString();

        return restTemplate.getForObject(url, CepResponseDTO.class);
    }
}