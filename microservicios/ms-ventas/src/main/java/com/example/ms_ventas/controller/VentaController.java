package com.example.ms_ventas.controller;

import com.example.ms_ventas.model.Venta;
import com.example.ms_ventas.service.VentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas")
public class VentaController {

    @Autowired
    private VentaService ventaService;

    @GetMapping
    public List<Venta> getVentas() {
        return ventaService.getVentas();
    }

    @GetMapping("/{id}")
    public Venta getVentaById(@PathVariable Long id) {
        return ventaService.getVentaById(id);
    }

    @PostMapping
    public Venta registrarVenta(@RequestParam Long carritoId,
                                @RequestParam Long usuarioId) {
        return ventaService.registrarVenta(carritoId, usuarioId);
    }
}
