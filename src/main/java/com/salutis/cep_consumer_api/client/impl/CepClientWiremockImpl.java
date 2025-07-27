package com.salutis.cep_consumer_api.client.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.salutis.cep_consumer_api.client.CepClient;
import com.salutis.cep_consumer_api.dto.CepResponseDTO;
import com.salutis.cep_consumer_api.exception.CepNotFoundException;

@Component
public class CepClientWiremockImpl implements CepClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "http://localhost:8089/ws/";

    @Override
public CepResponseDTO buscarCep(String cep) {
    String url = UriComponentsBuilder
            .fromHttpUrl(BASE_URL)
            .pathSegment(cep)
            .path("/json/")
            .toUriString();

    try {
        return restTemplate.getForObject(url, CepResponseDTO.class);
    } catch (HttpClientErrorException.NotFound e) {
        throw new CepNotFoundException(cep); 
    }
}


}