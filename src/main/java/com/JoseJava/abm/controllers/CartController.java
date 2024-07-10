package com.JoseJava.abm.controllers;

import com.JoseJava.abm.servicies.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/api/v1/carts")

public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{clientId}/add/{productId}")
    public void addToCart(@PathVariable("clientId") Long clientId,
                          @PathVariable("productoId") Long productId,
                          @RequestParam("quantity") Integer quantity) {
        cartService.addToCart(clientId, productId, quantity);
    }

    @DeleteMapping("/{clientId}/remove/{productoId}")
    public void removeFromCart(@PathVariable("clientId") Long clientId,
                               @PathVariable("productoId") Long productId,
                               @RequestParam("quantity") Integer quantity) {
        cartService.removeFromCart(clientId, productId, quantity);
    }
}
