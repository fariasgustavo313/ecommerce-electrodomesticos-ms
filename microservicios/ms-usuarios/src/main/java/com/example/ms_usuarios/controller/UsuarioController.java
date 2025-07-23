package com.example.ms_usuarios.controller;

import com.example.ms_usuarios.model.Usuario;
import com.example.ms_usuarios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioService.getUsuarioById(id);
    }

    @PostMapping
    public void saveUsuario(@RequestBody Usuario usuario) {
        usuarioService.saveUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }

    @PutMapping("/{id}")
    public void updateUsuario(@PathVariable Long id,
                              @RequestBody Usuario usuario) {
        usuarioService.updateUsuario(id, usuario);
    }
}
