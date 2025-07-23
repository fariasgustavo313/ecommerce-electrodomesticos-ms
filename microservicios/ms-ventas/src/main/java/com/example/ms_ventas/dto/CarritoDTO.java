package com.example.ms_ventas.dto;

import java.util.List;

public class CarritoDTO {

    private Long id;
    private List<Long> productoId;
    private Double total;

    public CarritoDTO(Long id, List<Long> productoId, Double total) {
        this.id = id;
        this.productoId = productoId;
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

    public List<Long> getProductoId() {
        return productoId;
    }

    public void setProductoId(List<Long> productoId) {
        this.productoId = productoId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
