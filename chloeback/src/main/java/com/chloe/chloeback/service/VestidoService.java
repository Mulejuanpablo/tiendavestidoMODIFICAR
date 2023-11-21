
//este servicio proporciona métodos para realizar operaciones relacionadas con la entidad Vestido utilizando el repositorio VestidoRepo.
package com.chloe.chloeback.service;

import java.util.List;
//import java.util.Optional;
import java.util.UUID;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chloe.chloeback.exception.UserNotFoundException;
import com.chloe.chloeback.model.Vestido;
import com.chloe.chloeback.repo.VestidoRepo;

//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.chloe.chloeback.repo.VestidoRepo;

//Estas anotaciones indican que esta clase es un componente de servicio de Spring y que todos sus métodos deben ejecutarse dentro de una transacción.
@Transactional
@Service
public class VestidoService {
    private final VestidoRepo vestidoRepo;// Se inyecta una instancia de VestidoRepo en el servicio a través del
                                          // constructor. Esto permite que el servicio utilice los métodos
                                          // proporcionados por VestidoRepo para interactuar con los datos de los
                                          // vestidos.

    // Constructor que inyecta una instancia de VestidoRepo al servicio
    public VestidoService(VestidoRepo vestidoRepo) {
        this.vestidoRepo = vestidoRepo;
    }

    // Método para agregar un nuevo vestido
    public Vestido addVestido(Vestido vestido) {

        return vestidoRepo.save(vestido);
    }

    // Método para obtener todos los vestidos
    public List<Vestido> findAllVestidos() {
        return vestidoRepo.findAll();
    }

    // Método para actualizar un vestido existente
    public Vestido updateVestido(Vestido vestido) {
        return vestidoRepo.save(vestido);
    }

    // Método para obtener un vestido por su identificador
    public Vestido findVestidoById(Long id) {
        return vestidoRepo.findVestidoById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    // Método para eliminar un vestido por su identificador
    public void deleteVestido(Long id) {
        vestidoRepo.deleteById(id);
    }

    // Método para buscar vestidos por nombre, color, talle o descripción
    public List<Vestido> searchVestidos(String key) {
        return vestidoRepo.findByNombreContainingOrColorContainingOrTalleContainingOrDescripcionContaining(key, key,
                key, key);

    }
}
