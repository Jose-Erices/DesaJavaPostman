package com.JoseJava.abm.servicies;

import com.JoseJava.abm.entities.Producto;
import com.JoseJava.abm.repositoies.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    public Producto saveProducto(Producto producto) {
        return repository.save(producto);
    }

    public List<Producto> findAllProductos() {
        return repository.findAll();
    }

    public Optional<Producto> findProductoById(Long id) {
        return repository.findById(id);
    }

    public void deleteProducto(Long id) {
        repository.deleteById(id);
    }
}

