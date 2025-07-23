package com.example.ms_carrito.repository;

import com.example.ms_carrito.dto.ProductoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-productos")
public interface ProductoAPIClient {

    @GetMapping("/productos/{id}")
    ProductoDTO getProductoById(@PathVariable Long id);
}
