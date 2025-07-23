package com.example.ms_productos.service;

import com.example.ms_productos.model.Producto;
import com.example.ms_productos.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos() {
        return productoRepository.findAll();
    }

    public Producto getProductoById(Long id) {
        return productoRepository.findById(id).orElse(null);
    }

    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }

    public void updateProducto(Long id, Producto producto) {
        Producto p = productoRepository.findById(id).orElse(null);

        p.setCodigo(producto.getCodigo());
        p.setNombre(producto.getNombre());
        p.setMarca(producto.getMarca());
        p.setPrecio(producto.getPrecio());

        productoRepository.save(p);
    }
}
