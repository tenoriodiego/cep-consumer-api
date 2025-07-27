package com.salutis.cep_consumer_api.service.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.salutis.cep_consumer_api.client.CepClient;
import com.salutis.cep_consumer_api.dto.CepResponseDTO;
import com.salutis.cep_consumer_api.exception.CampoVazioException;
import com.salutis.cep_consumer_api.exception.CepNotFoundException;
import com.salutis.cep_consumer_api.model.ConsultaLog;
import com.salutis.cep_consumer_api.repository.ConsultaLogRepository;
import com.salutis.cep_consumer_api.service.CepService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CepServiceImpl implements CepService {

    private final CepClient cepClient;
    private final ObjectMapper objectMapper;
    private final ConsultaLogRepository consultaLogRepository;

    @Override
    public CepResponseDTO buscarCep(String cep) {
        if (cep == null || cep.isEmpty() || cep.isBlank()) {
            salvarLog(cep, "CEP vazio");
            throw new CampoVazioException("CEP não pode ser vazio");
        }

        try {
            CepResponseDTO response = cepClient.buscarCep(cep);

            String resultadoJson = objectMapper.writeValueAsString(response);
            salvarLog(cep, resultadoJson);

            return response;
        } catch (CepNotFoundException e) {
            salvarLog(cep, "CEP não encontrado");
            throw e; // deixa a exceção subir
        } catch (Exception e) {
            salvarLog(cep, "Erro inesperado: " + e.getMessage());
            throw new RuntimeException("Erro ao consultar CEP", e);
        }
    }

    private void salvarLog(String cep, String resultado) {
        ConsultaLog log = ConsultaLog.builder()
            .cep(cep)
            .resultado(resultado)
            .dataHora(LocalDateTime.now())
            .build();

        consultaLogRepository.save(log);
    }
}





