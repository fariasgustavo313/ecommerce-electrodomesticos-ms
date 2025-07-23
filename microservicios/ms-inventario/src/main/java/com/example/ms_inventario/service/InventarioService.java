package com.example.ms_inventario.service;

import com.example.ms_inventario.model.Inventario;
import com.example.ms_inventario.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    public List<Inventario> getInventarios() {
        return inventarioRepository.findAll();
    }

    public Inventario getInventarioById(Long id) {
        return inventarioRepository.findById(id).orElse(null);
    }

    public Optional<Inventario> getInventarioByProductoId(Long productoId) {
        return inventarioRepository.findByProductoId(productoId);
    }

    public void saveInventario(Inventario inventario) {
        inventarioRepository.save(inventario);
    }

    public void deleteInventario(Long id) {
        inventarioRepository.deleteById(id);
    }

    public void updateInventario(Long id, Inventario inventario) {
        Inventario i = inventarioRepository.findById(id).orElse(null);

        i.setProductoId(inventario.getProductoId());
        i.setStock(inventario.getStock());

        inventarioRepository.save(i);
    }
}
