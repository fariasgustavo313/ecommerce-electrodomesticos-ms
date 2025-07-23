package com.example.ms_ventas.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "ms-auditoria")
public interface AuditoriaAPIClient {

    @PostMapping("/auditoria")

}
