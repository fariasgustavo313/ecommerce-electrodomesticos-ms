package com.example.ms_ventas.repository;

import com.example.ms_ventas.dto.EventoAuditoriaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ms-auditoria")
public interface AuditoriaAPIClient {

    @PostMapping("/auditoria")
    EventoAuditoriaDTO registrarEvento(@RequestBody EventoAuditoriaDTO evento);
}
