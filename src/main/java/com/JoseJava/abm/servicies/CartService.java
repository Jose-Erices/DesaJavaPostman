package com.JoseJava.abm.servicies;

import com.JoseJava.abm.entities.Client;
import com.JoseJava.abm.entities.Producto;
import com.JoseJava.abm.repositoies.ClientsRepository;
import com.JoseJava.abm.repositoies.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private ClientsRepository clientsRepository;

    @Autowired
    private ProductoRepository productoRepository;

    public void addToCart(Long clientId, Long productId, Integer quantity) {
        Optional<Client> client = clientsRepository.findById(clientId);
        Optional<Producto> product = productoRepository.findById(productId);

        if (client.isPresent() && product.isPresent()) {
            // Aquí puedes implementar la lógica para agregar el producto al carrito del cliente
            // Por ejemplo, podrías tener una entidad CartItem y un repositorio CartItemRepository para manejar esto.
            // Aquí lo estoy simplificando asumiendo que tienes una relación directa entre Cliente y Producto.
        } else {
            throw new RuntimeException("Cliente o producto no encontrado");
        }
    }

    public void removeFromCart(Long clientId, Long productId, Integer quantity) {
        // Implementa la lógica para remover un producto del carrito del cliente
    }
}
