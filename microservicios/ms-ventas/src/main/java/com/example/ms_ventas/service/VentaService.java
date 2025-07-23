package com.example.ms_ventas.service;

import com.example.ms_ventas.dto.CarritoDTO;
import com.example.ms_ventas.dto.EventoAuditoriaDTO;
import com.example.ms_ventas.dto.UsuarioDTO;
import com.example.ms_ventas.model.Venta;
import com.example.ms_ventas.repository.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class VentaService {

    @Autowired
    private VentaRepository ventaRepository;

    @Autowired
    private CarritoAPIClient carritoAPIClient;

    @Autowired
    private UsuarioAPIClient usuarioAPIClient;

    @Autowired
    private InventarioAPIClient inventarioAPIClient;

    @Autowired
    private AuditoriaAPIClient auditoriaAPIClient;

    public List<Venta> getVentas() {
        return ventaRepository.findAll();
    }

    public Venta getVentaById(Long id) {
        return ventaRepository.findById(id).orElse(null);
    }

    public Venta registrarVenta(Long carritoId, Long usuarioId) {
        CarritoDTO carrito = carritoAPIClient.getCarritoById(carritoId);
        UsuarioDTO usuario = usuarioAPIClient.getUsuarioById(usuarioId);

        for (Long productoId : carrito.getProductos()) {
            restarStockSeguro(productoId, 1);
        }

        Venta venta = new Venta();
        venta.setFecha(LocalDateTime.now());
        venta.setCarritoId(carritoId);
        venta.setUsuarioId(usuarioId);
        venta.setTotal(carrito.getTotal());
        Venta ventaRegistrada = ventaRepository.save(venta);

        EventoAuditoriaDTO evento = new EventoAuditoriaDTO();
        evento.setServicio("ms-ventas");
        evento.setDescripcion("Venta registrada: id=" + ventaRegistrada.getId() + ", total=" + ventaRegistrada.getTotal());
        evento.setFecha(LocalDateTime.now());
        auditoriaAPIClient.registrarEvento(evento);
        
        return ventaRegistrada;
    }

    @CircuitBreaker(name = "inventarioCB", fallbackMethod = "fallbackRestarStock")
    @Retry(name = "inventarioRetry")
    public void restarStockSeguro(Long productoId, Integer cantidad) {
        inventarioAPIClient.restarStock(productoId, cantidad);
    }

    // Fallback para cuando no se puede descontar stock
    public void fallbackRestarStock(Long productoId, Integer cantidad, Throwable t) {
        System.out.println("No se pudo descontar stock para producto: " + productoId + "(cantidad: " + cantidad + "). Error: " + t.getMessage());
    }
}
