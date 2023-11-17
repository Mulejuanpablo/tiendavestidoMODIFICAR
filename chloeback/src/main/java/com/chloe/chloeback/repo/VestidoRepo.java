package com.chloe.chloeback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chloe.chloeback.model.Vestido;

import java.util.List;
import java.util.Optional;

public interface VestidoRepo extends JpaRepository<Vestido, Long>{
void deleteById(Long id);

Optional<Vestido> findVestidoById(Long id);
    
List<Vestido> findByNombreContainingOrColorContainingOrTalleContainingOrDescripcionContaining(String nombre, String color, String talle, String descripcion);
    
}
