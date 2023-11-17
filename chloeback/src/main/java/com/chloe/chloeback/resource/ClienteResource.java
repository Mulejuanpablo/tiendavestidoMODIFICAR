package com.chloe.chloeback.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.chloe.chloeback.model.Cliente;
import com.chloe.chloeback.service.ClienteService;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
    private final ClienteService clienteService;

    public ClienteResource(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/allcliente")
    public ResponseEntity<List<Cliente>> getAllClientes () {
        List<Cliente> clientes = clienteService.findAllClientes();
        return new ResponseEntity<>(clientes, HttpStatus.OK);
    }

    @GetMapping("/findcliente/{id}")
    public ResponseEntity<Cliente> getClienteByIdcliente (@PathVariable("id") Long id) {
        Cliente cliente = clienteService.findClienteById(id);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @PostMapping("/addcliente")
    public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente) {
        Cliente newCliente = clienteService.addCliente(cliente);
        return new ResponseEntity<>(newCliente, HttpStatus.CREATED);
    }

    @PutMapping("/updatecliente")
    public ResponseEntity<Cliente> updateCliente(@RequestBody Cliente cliente) {
        Cliente updateCliente = clienteService.updateCliente(cliente);
        return new ResponseEntity<>(updateCliente, HttpStatus.OK);
    }

    @DeleteMapping("/deletecliente/{id}")
    public ResponseEntity<?> deleteCliente(@PathVariable("id") Long id) {
        clienteService.deleteCliente(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
