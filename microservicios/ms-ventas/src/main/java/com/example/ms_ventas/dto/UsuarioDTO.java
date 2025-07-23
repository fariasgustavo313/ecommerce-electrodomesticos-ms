package com.example.ms_ventas.dto;

public class UsuarioDTO {

    private Long id;
    private String nombre;
    private String email;
    private String direccion;
    private String dni;

    public UsuarioDTO(Long id, String nombre, String email, String direccion, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.direccion = direccion;
        this.dni = dni;
    }

    public UsuarioDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
