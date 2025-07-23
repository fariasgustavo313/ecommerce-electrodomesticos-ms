package com.example.ms_auditoria.service;

import com.example.ms_auditoria.model.EventoAuditoria;
import com.example.ms_auditoria.repository.EventoAuditoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventoAuditoriaService {

    @Autowired
    private EventoAuditoriaRepository eventoAuditoriaRepository;

    public List<EventoAuditoria> getEventosAuditorias() {
        return eventoAuditoriaRepository.findAll();
    }

    public EventoAuditoria registrarEvento(@RequestBody EventoAuditoria evento) {
        evento.setFecha(LocalDateTime.now());
        return eventoAuditoriaRepository.save(evento);
    }
}
