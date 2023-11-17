package com.chloe.chloeback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chloe.chloeback.model.Evento;

import java.util.Optional;

public interface EventoRepo extends JpaRepository<Evento, Long>{
void deleteById(Long id);

Optional<Evento> findEventoById(Long id);
}