package com.example.ms_ventas.repository;

import com.example.ms_ventas.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-usuarios")
public interface UsuarioAPIClient {

    @GetMapping("/usuarios/{id}")
    UsuarioDTO getUsuarioById(@PathVariable Long id);
}
