package com.JoseJava.abm.controllers;

import com.JoseJava.abm.entities.Producto;
import com.JoseJava.abm.servicies.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/productos")
public class ProductoController {
    @Autowired
    private ProductoService service;

    @PostMapping()
    public Producto saveProducto(@RequestBody Producto producto) {
        return service.saveProducto(producto);
    }

    @GetMapping()
    public List<Producto> findAllProductos() {
        return service.findAllProductos();
    }

    @GetMapping("/{id}")
    public Optional<Producto> findProductoById(@PathVariable("id") Long id) {
        return service.findProductoById(id);
    }

    @PutMapping("/{id}")
    public Producto updateProducto(@PathVariable("id") Long id, @RequestBody Producto producto) {
        // Primero, verifica si el producto con el ID proporcionado existe en la base de datos
        Optional<Producto> optionalProducto = service.findProductoById(id);

        if (optionalProducto.isPresent()) {
            // El producto existe, por lo tanto, obtenemos la instancia del producto desde Optional
            Producto existingProducto = optionalProducto.get();

            // Actualizamos los campos del producto existente con los nuevos valores recibidos en el cuerpo de la solicitud
            if (producto.getNombre() != null) {
                existingProducto.setNombre(producto.getNombre());
            }
            if (producto.getDescripcion() != null) {
                existingProducto.setDescripcion(producto.getDescripcion());
            }
            if (producto.getPrecio() != null) {
                existingProducto.setPrecio(producto.getPrecio());
            }

            // Guardamos el producto actualizado en la base de datos y lo devolvemos como respuesta
            return service.saveProducto(existingProducto);
        } else {
            // Si el producto no existe, lanzamos una excepción
            throw new RuntimeException("Producto no encontrado con id: " + id);
        }
    }



    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable("id") Long id) {
        service.deleteProducto(id);
    }
}
