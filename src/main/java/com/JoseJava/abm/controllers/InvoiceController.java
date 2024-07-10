package com.JoseJava.abm.controllers; // Asegúrate de estar en el mismo paquete que los otros controladores

import com.JoseJava.abm.entities.*;
import com.JoseJava.abm.servicies.*; // Asegúrate de importar el servicio correcto
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="/api/v1/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/{clientId}")
    public void generateInvoice(@PathVariable("clientId") Long clientId) {
        invoiceService.generateInvoice(clientId);
    }

    @GetMapping("/{clientId}")
    public List<InvoiceService> getInvoicesByClient(@PathVariable("clientId") Long clientId) {
        return invoiceService.getInvoicesByClient(clientId);
    }
}
