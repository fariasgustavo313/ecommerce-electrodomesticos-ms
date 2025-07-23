package com.example.ms_auditoria.repository;

import com.example.ms_auditoria.model.EventoAuditoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventoAuditoriaRepository extends JpaRepository<EventoAuditoria, Long> {
}
