package com.example.ms_usuarios.service;

import com.example.ms_usuarios.model.Usuario;
import com.example.ms_usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public void saveUsuario(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void updateUsuario(Long id, Usuario usuario) {
        Usuario u = usuarioRepository.findById(id).orElse(null);

        u.setNombre(usuario.getNombre());
        u.setEmail(usuario.getEmail());
        u.setDireccion(usuario.getDireccion());
        u.setDni(usuario.getDni());

        usuarioRepository.save(u);
    }
}
