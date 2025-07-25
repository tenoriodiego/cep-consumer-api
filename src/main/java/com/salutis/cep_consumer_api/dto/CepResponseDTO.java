package com.salutis.cep_consumer_api.dto;

import lombok.Data;

@Data
public class CepResponseDTO {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
    
}
