package com.chloe.chloeback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chloe.chloeback.model.Cliente;

import java.util.Optional;

public interface ClienteRepo extends JpaRepository<Cliente, Long>{
void deleteById(Long id);

Optional<Cliente> findClienteById(Long id);
}