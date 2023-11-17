package com.chloe.chloeback.service;

import java.util.List;
//import java.util.Optional;
import java.util.UUID;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chloe.chloeback.exception.UserNotFoundException;
import com.chloe.chloeback.model.Cliente;
//import com.chloe.chloeback.model.Cliente;
import com.chloe.chloeback.repo.ClienteRepo;

//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.chloe.chloeback.repo.ClienteRepo;

@Transactional
@Service
public class ClienteService {
    private final ClienteRepo clienteRepo;

  //  @Autowired
    public ClienteService(ClienteRepo clienteRepo) {
        this.clienteRepo = clienteRepo;
    }

    public Cliente addCliente(Cliente cliente) {
        cliente.setApellido(UUID.randomUUID().toString());
        return clienteRepo.save(cliente);
    }

    public List<Cliente> findAllClientes() {
        return clienteRepo.findAll();
    }

    public Cliente updateCliente(Cliente cliente) {
        return clienteRepo.save(cliente);
    }

    public Cliente findClienteById(Long id) {
        return clienteRepo.findClienteById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteCliente(Long id) {
        clienteRepo.deleteById(id);
    }

}
