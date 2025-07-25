package com.salutis.cep_consumer_api.service;

import com.salutis.cep_consumer_api.dto.CepResponseDTO;

public interface CepService {

    CepResponseDTO buscarCep(String cep);
    
}
