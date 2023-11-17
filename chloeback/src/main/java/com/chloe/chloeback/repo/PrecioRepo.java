package com.chloe.chloeback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chloe.chloeback.model.Precio;

import java.util.Optional;

public interface PrecioRepo extends JpaRepository<Precio, Long>{
void deleteById(Long id);

Optional<Precio> findPrecioById(Long id);
}