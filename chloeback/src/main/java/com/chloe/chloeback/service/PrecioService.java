package com.chloe.chloeback.service;

import java.util.List;
//import java.util.Optional;
import java.util.UUID;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chloe.chloeback.exception.UserNotFoundException;
import com.chloe.chloeback.model.Precio;
//import com.chloe.chloeback.model.Precio;
import com.chloe.chloeback.repo.PrecioRepo;

//import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.chloe.chloeback.repo.PrecioRepo;

@Transactional
@Service
public class PrecioService {
    private final PrecioRepo precioRepo;

   // @Autowired
    public PrecioService(PrecioRepo precioRepo) {
        this.precioRepo = precioRepo;
    }

    public Precio addPrecio(Precio precio) {
        precio.setPreciocolor(UUID.randomUUID().toString());
        return precioRepo.save(precio);
    }

    public List<Precio> findAllPrecios() {
        return precioRepo.findAll();
    }

    public Precio updatePrecio(Precio precio) {
        return precioRepo.save(precio);
    }

    public Precio findPrecioById(Long id) {
        return precioRepo.findPrecioById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deletePrecio(Long id) {
        precioRepo.deleteById(id);
    }

}
