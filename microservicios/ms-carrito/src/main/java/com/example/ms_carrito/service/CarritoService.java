package com.example.ms_carrito.service;

import com.example.ms_carrito.dto.ProductoDTO;
import com.example.ms_carrito.model.Carrito;
import com.example.ms_carrito.repository.CarritoRepository;
import com.example.ms_carrito.repository.ProductoAPIClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Autowired
    private ProductoAPIClient productoAPIClient;

    public List<Carrito> getCarritos() {
        return carritoRepository.findAll();
    }

    public Carrito getCarritoById(Long id) {
        return carritoRepository.findById(id).orElse(null);
    }

    public Carrito createCarrito() {
        Carrito c = new Carrito();
        c.setTotal(0.0);
        return carritoRepository.save(c);
    }

    public Carrito saveCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    public Carrito agregarProducto(Long carritoId, Long productoId) {
        Carrito carrito = carritoRepository.findById(carritoId).orElseThrow();
        carrito.getProductos().add(productoId);
        carrito.setTotal(calcularTotal(carrito));

        return carritoRepository.save(carrito);
    }

    public Carrito quitarProducto(Long carritoId, Long productoId) {
        Carrito carrito = carritoRepository.findById(carritoId).orElseThrow();
        carrito.getProductos().remove(productoId);
        carrito.setTotal(calcularTotal(carrito));

        return carritoRepository.save(carrito);
    }

    public Double calcularTotal(Carrito carrito) {
        double total = 0.0;
        for (Long productoId : carrito.getProductos()) {
            ProductoDTO p = productoAPIClient.getProductoById(productoId);
            if (p != null) total += p.getPrecio();
        }
        return total;
    }
}
