package com.example.ms_ventas.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-inventario")
public interface InventarioAPIClient {

    @PostMapping("/inventario/{productoId}/restar")
    void restarStock(@PathVariable Long productoId, @RequestParam Integer cantidad);
}
