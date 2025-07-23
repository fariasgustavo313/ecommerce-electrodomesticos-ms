package com.example.ms_auditoria.controller;

import com.example.ms_auditoria.model.EventoAuditoria;
import com.example.ms_auditoria.service.EventoAuditoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auditoria")
public class EventoAuditoriaController {

    @Autowired
    private EventoAuditoriaService eventoAuditoriaService;

    @GetMapping
    public List<EventoAuditoria> getEventosAuditorias() {
        return eventoAuditoriaService.getEventosAuditorias();
    }

    @PostMapping
    public EventoAuditoria registrarEvento(@RequestBody EventoAuditoria evento) {
        return eventoAuditoriaService.registrarEvento(evento);
    }
}
