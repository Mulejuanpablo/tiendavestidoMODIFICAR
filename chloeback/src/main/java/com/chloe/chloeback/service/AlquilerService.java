package com.chloe.chloeback.service;

import java.util.List;
//import java.util.Optional;
//import java.util.UUID;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chloe.chloeback.exception.UserNotFoundException;
import com.chloe.chloeback.model.Alquiler;
//import com.chloe.chloeback.model.Alquiler;
import com.chloe.chloeback.repo.AlquilerRepo;

//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.chloe.chloeback.repo.PrecioRepo;

@Transactional
@Service
public class AlquilerService {
    private final AlquilerRepo alquilerRepo;

   // @Autowired
    public AlquilerService(AlquilerRepo alquilerRepo) {
        this.alquilerRepo = alquilerRepo;
    }

    public Alquiler addAlquiler(Alquiler alquiler) {
    return alquilerRepo.save(alquiler);
    }

    public List<Alquiler> findAllAlquileres() {
        return alquilerRepo.findAll();
    }

    public Alquiler updateAlquiler(Alquiler alquiler) {
        return alquilerRepo.save(alquiler);
    }

    public Alquiler findAlquilerById(Long id) {
        return alquilerRepo.findAlquilerById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteAlquiler(Long id) {
        alquilerRepo.deleteById(id);
    }

}
