package com.JoseJava.abm.controllers;

import com.JoseJava.abm.entities.Client;
import com.JoseJava.abm.entities.Producto;
import com.JoseJava.abm.servicies.ClientServicie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/clients")

public class ClientsController {
   @Autowired
   private ClientServicie service;

   @PostMapping()
    public  void saveClient(@RequestBody Client client) {

       try {
           service.saveClient(client);
       } catch (Exception exception) {

           System.out.println(exception);
           throw new RuntimeException("CREATE ERROR");
       }
   }
    @GetMapping()
    public List<Client>readClients(){

        try {
            return service.readClients();
        } catch (Exception exception) {

            System.out.println(exception);
            throw new RuntimeException("READ ALL ERROR");
        }
    }
    @GetMapping("/{id}")
      public  Optional<Client> readClient(@PathVariable("id")Long id) {

        try {
            return service.readOneClient(id);
        } catch (Exception exception) {

            System.out.println(exception);
            throw new RuntimeException("READ ONE ERROR");
        }
    }

    @PutMapping("/{id}")
    public Client updateClient(@PathVariable("id") Long id, @RequestBody Client updatedClient) {
        try {
            // Verificar si el cliente con el id proporcionado existe
            Optional<Client> existingClient = service.readOneClient(id);
            if (existingClient.isPresent()) {
                Client clientToUpdate = existingClient.get();
                // Actualizar solo los campos necesarios del cliente
                clientToUpdate.setName(updatedClient.getName());
                clientToUpdate.setLastname(updatedClient.getLastname());
                clientToUpdate.setEdad(updatedClient.getEdad());
                clientToUpdate.setRUT(updatedClient.getRUT());
                // Guardar el cliente actualizado
                service.saveClient(clientToUpdate);
                return clientToUpdate;
            } else {
                throw new RuntimeException("Client not found with id: " + id);
            }
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("UPDATE ERROR");
        }
    }

@DeleteMapping ("/{id}")

public  void  destroyOneClient(@PathVariable("id")Long id) {
    try {
        service.destroyOneClient(id);
    } catch (Exception exception) {

        System.out.println(exception);
        throw new RuntimeException("DELETE ONE ERROR");
    }
}


}







