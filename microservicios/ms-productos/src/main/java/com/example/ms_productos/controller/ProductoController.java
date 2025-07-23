package com.example.ms_productos.controller;

import com.example.ms_productos.model.Producto;
import com.example.ms_productos.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    @GetMapping("/{id}")
    public Producto getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    @PostMapping
    public void saveProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);
    }

    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }

    @PutMapping("/{id}")
    public void updateProducto(@PathVariable Long id,
                               @RequestBody Producto producto) {
        productoService.updateProducto(id, producto);
    }
}
