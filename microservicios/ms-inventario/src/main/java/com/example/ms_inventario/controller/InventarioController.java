package com.example.ms_inventario.controller;

import com.example.ms_inventario.model.Inventario;
import com.example.ms_inventario.service.InventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<Inventario> getInventarios() {
        return inventarioService.getInventarios();
    }

    @GetMapping("/{id}")
    public Inventario getInventarioById(@PathVariable Long id) {
        return inventarioService.getInventarioById(id);
    }

    @GetMapping("/producto/{productoId}")
    public Optional<Inventario> getInventarioByProductoId(@PathVariable Long productoId) {
        return inventarioService.getInventarioByProductoId(productoId);
    }

    @PostMapping
    public void saveInventario(@RequestBody Inventario inventario) {
        inventarioService.saveInventario(inventario);
    }

    @DeleteMapping("/{id}")
    public void deleteInventario(@PathVariable Long id) {
        inventarioService.deleteInventario(id);
    }

    @PutMapping("/{id}")
    public void updateInventario(@PathVariable Long id,
                                 @RequestBody Inventario inventario) {
        inventarioService.updateInventario(id, inventario);
    }

    // Operaciones para sumar/restar stock
    @PostMapping("/{productoId}/sumar")
    public Inventario sumarStock(@PathVariable Long productoId, @RequestParam Integer cantidad) {
        Inventario inv = inventarioService.getInventarioByProductoId(productoId)
                .orElseGet(() -> {
                    Inventario nuevo = new Inventario();
                    nuevo.setProductoId(productoId);
                    nuevo.setStock(0);
                    return nuevo;
                });
        inv.setStock(inv.getStock() + cantidad);
        return inventarioService.saveInventario(inv);
    }

    @PostMapping("/{productoId}/restar")
    public Inventario restarStock(@PathVariable Long productoId, @RequestParam Integer cantidad) {
        Inventario inv = inventarioService.getInventarioByProductoId(productoId)
                .orElseThrow();
        int nuevoStock = inv.getStock() - cantidad;
        if (nuevoStock < 0) nuevoStock = 0;
        inv.setStock(nuevoStock);
        return inventarioService.saveInventario(inv);
    }
}
