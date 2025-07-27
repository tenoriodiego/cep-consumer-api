package com.salutis.cep_consumer_api.service.impl;

import java.util.regex.Pattern;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.salutis.cep_consumer_api.dto.CepResponseDTO;
import com.salutis.cep_consumer_api.exception.CepNotFoundException;
import com.salutis.cep_consumer_api.service.CepService;

@Service
public class CepServiceImpl implements CepService {

    private final RestTemplate restTemplate;
    private final Pattern cepPattern = Pattern.compile("^\\d{5}-\\d{3}$");

    public CepServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CepResponseDTO buscarCep(String cep) {
        if (cep == null || cep.isBlank()) {
            throw new IllegalArgumentException("CEP não pode estar vazio.");
        }

        if (!cepPattern.matcher(cep).matches()) {
            throw new IllegalArgumentException("CEP inválido. Use o formato 99999-999.");
        }

        String url = "http://localhost:8089/ws/" + cep + "/json/";

        try {
            ResponseEntity<CepResponseDTO> response = restTemplate.getForEntity(url, CepResponseDTO.class);
            return response.getBody();
        } catch (HttpClientErrorException.NotFound e) {
            throw new CepNotFoundException();
        }
    }
}
