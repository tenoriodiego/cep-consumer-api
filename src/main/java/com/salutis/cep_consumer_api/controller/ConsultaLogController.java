package com.salutis.cep_consumer_api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.salutis.cep_consumer_api.dto.ConsultaLogDTO;
import com.salutis.cep_consumer_api.repository.ConsultaLogRepository;

@RestController
@RequestMapping("/logs")
public class ConsultaLogController {

    private final ConsultaLogRepository consultaLogRepository;

    public ConsultaLogController(ConsultaLogRepository consultaLogRepository) {
        this.consultaLogRepository = consultaLogRepository;
    }

    @GetMapping
    public List<ConsultaLogDTO> listarTodos() {
        return consultaLogRepository.findAll().stream()
            .map(ConsultaLogDTO::fromEntity)
            .toList();
    }
}
