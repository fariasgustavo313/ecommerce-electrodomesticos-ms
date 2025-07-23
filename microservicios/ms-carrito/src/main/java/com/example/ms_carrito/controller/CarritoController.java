package com.example.ms_carrito.controller;

import com.example.ms_carrito.model.Carrito;
import com.example.ms_carrito.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public List<Carrito> getCarritos() {
        return carritoService.getCarritos();
    }

    @GetMapping("/{id}")
    public Carrito getCarritoById(@PathVariable Long id) {
        return carritoService.getCarritoById(id);
    }

    @PostMapping
    public Carrito createCarrito() {
        return carritoService.createCarrito();
    }

    @PostMapping("/{carritoId}/productos/{productoId}")
    public Carrito agregarProducto(@PathVariable Long carritoId,
                                   @PathVariable Long productoId) {
        return carritoService.agregarProducto(carritoId, productoId);
    }

    @DeleteMapping("/{carritoId}/productos/{productoId}")
    public Carrito quitarProducto(@PathVariable Long carritoId,
                                  @PathVariable Long productoId) {
        return carritoService.quitarProducto(carritoId, productoId);
    }

    @PutMapping("/{carritoId}/calcular_total")
    public Carrito calcularTotal(@PathVariable Long carritoId) {
        Carrito c = carritoService.getCarritoById(carritoId);
        c.setTotal(carritoService.calcularTotal(c));
        return carritoService.saveCarrito(c);
    }
}
