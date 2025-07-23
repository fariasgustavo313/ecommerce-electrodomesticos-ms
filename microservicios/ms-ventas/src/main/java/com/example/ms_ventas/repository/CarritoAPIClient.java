package com.example.ms_ventas.repository;

import com.example.ms_ventas.dto.CarritoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-carrito")
public interface CarritoAPIClient {

    @GetMapping("/carrito/{id}")
    CarritoDTO getCarritoById(@PathVariable Long id);
}
