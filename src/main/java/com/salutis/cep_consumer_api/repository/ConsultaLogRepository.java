package com.salutis.cep_consumer_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salutis.cep_consumer_api.model.ConsultaLog;

public interface ConsultaLogRepository extends JpaRepository<ConsultaLog, Long> {
}
