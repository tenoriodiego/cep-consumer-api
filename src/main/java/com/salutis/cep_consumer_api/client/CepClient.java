package com.salutis.cep_consumer_api.client;

import com.salutis.cep_consumer_api.dto.CepResponseDTO;

public interface CepClient {
    CepResponseDTO buscarCep(String cep);
}
