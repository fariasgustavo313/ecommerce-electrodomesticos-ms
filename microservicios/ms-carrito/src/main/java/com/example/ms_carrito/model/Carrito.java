package com.example.ms_carrito.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double total;
    @ElementCollection
    private List<Long> productos = new ArrayList<>();

    public Carrito(Long id, Double total, List<Long> productos) {
        this.id = id;
        this.total = total;
        this.productos = productos;
    }

    public Carrito() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<Long> getProductos() {
        return productos;
    }

    public void setProductos(List<Long> productos) {
        this.productos = productos;
    }
}
