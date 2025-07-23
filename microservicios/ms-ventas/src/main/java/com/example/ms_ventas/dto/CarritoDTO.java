package com.example.ms_ventas.dto;

import java.util.List;

public class CarritoDTO {

    private Long id;
    private List<Long> productos;
    private Double total;

    public CarritoDTO(Long id, List<Long> productos, Double total) {
        this.id = id;
        this.productos = productos;
        this.total = total;
    }

    public CarritoDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getProductos() {
        return productos;
    }

    public void setProductos(List<Long> productos) {
        this.productos = productos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
