package com.JoseJava.abm.servicies;


import com.JoseJava.abm.entities.Client;
import com.JoseJava.abm.entities.Producto;
import com.JoseJava.abm.repositoies.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServicie {

@Autowired
    private ClientsRepository repository;

    public  void  saveClient(Client client) {
        repository.save(client);

    }
    public List<Client> readClients(){
        return repository.findAll();
    }
    public Optional<Client> readOneClient(Long id){
        return repository.findById(id);
}

    public void destroyOneClient(Long id) {
        repository.deleteById(id);

    }


    public Optional<Producto> findProductoById(Long id) {
        return Optional.empty();
    }

    public Producto saveProducto(Producto existingProducto) {
        return existingProducto;
    }
}