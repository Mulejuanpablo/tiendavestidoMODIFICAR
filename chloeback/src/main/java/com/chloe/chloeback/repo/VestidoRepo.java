//esta interfaz proporciona métodos predefinidos y personalizados para realizar operaciones de base de datos relacionadas con la entidad Vestido, como la búsqueda y eliminación de vestidos.
package com.chloe.chloeback.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.chloe.chloeback.model.Vestido;
import java.util.List;
import java.util.Optional;

// Método para eliminar un vestido por su identificador
public interface VestidoRepo extends JpaRepository<Vestido, Long> {
    void deleteById(Long id);

    // Método para encontrar un vestido por su identificador
    Optional<Vestido> findVestidoById(Long id);

    // Método para buscar vestidos por nombre, color, talle o descripción
    List<Vestido> findByNombreContainingOrColorContainingOrTalleContainingOrDescripcionContaining(String nombre,
            String color, String talle, String descripcion);

}
