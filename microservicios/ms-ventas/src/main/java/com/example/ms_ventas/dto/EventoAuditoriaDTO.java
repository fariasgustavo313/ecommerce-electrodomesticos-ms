package com.example.ms_ventas.dto;

import java.time.LocalDateTime;

public class EventoAuditoriaDTO {

    private Long id;
    private String servicio;
    private String descripcion;
    private LocalDateTime fecha;

    public EventoAuditoriaDTO(Long id, String servicio, String descripcion, LocalDateTime fecha) {
        this.id = id;
        this.servicio = servicio;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public EventoAuditoriaDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}
