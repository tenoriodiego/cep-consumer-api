package com.salutis.cep_consumer_api.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.salutis.cep_consumer_api.client.CepClient;
import com.salutis.cep_consumer_api.dto.CepResponseDTO;
import com.salutis.cep_consumer_api.model.ConsultaLog;
import com.salutis.cep_consumer_api.repository.ConsultaLogRepository;
import com.salutis.cep_consumer_api.service.CepService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CepServiceImpl implements CepService {

    private final CepClient cepClient;
    private final ConsultaLogRepository logRepository;

    @Override
    public CepResponseDTO buscarCep(String cep) {
        CepResponseDTO response = cepClient.buscarCep(cep);

        ConsultaLog log = ConsultaLog.builder()
                .cep(cep)
                .resultado(response.toString())
                .dataHora(LocalDateTime.now())
                .build();

        logRepository.save(log);

        return response;
    }
}