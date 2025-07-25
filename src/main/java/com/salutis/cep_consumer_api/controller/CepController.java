package com.salutis.cep_consumer_api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salutis.cep_consumer_api.dto.CepResponseDTO;
import com.salutis.cep_consumer_api.service.CepService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/cep")
@RequiredArgsConstructor
public class CepController {

    private final CepService cepService;

    @GetMapping("/{cep}")
    public ResponseEntity<CepResponseDTO> buscarCep(@PathVariable String cep) {
        CepResponseDTO response = cepService.buscarCep(cep);
        return ResponseEntity.ok(response);
    }
}
    
