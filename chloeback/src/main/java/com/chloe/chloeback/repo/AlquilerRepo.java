package com.chloe.chloeback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chloe.chloeback.model.Alquiler;

import java.util.Optional;

public interface AlquilerRepo extends JpaRepository<Alquiler, Long>{
void deleteById(Long id);

Optional<Alquiler> findAlquilerById(Long id);
}