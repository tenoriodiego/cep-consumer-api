package com.salutis.cep_consumer_api.dto;

import java.time.LocalDateTime;

import com.salutis.cep_consumer_api.model.ConsultaLog;

public record ConsultaLogDTO(
    Long id,
    String cep,
    String resultado,
    LocalDateTime dataHora
) {
    public static ConsultaLogDTO fromEntity(ConsultaLog entity) {
        return new ConsultaLogDTO(
            entity.getId(),
            entity.getCep(),
            entity.getResultado(),
            entity.getDataHora()
        );
    }
}

