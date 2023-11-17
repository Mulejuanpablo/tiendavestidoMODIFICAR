package com.chloe.chloeback.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.chloe.chloeback.model.Alquiler;
import com.chloe.chloeback.service.AlquilerService;

import java.util.List;

@RestController
@RequestMapping("/alquiler")
public class AlquilerResource {
    private final AlquilerService alquilerService;

    public AlquilerResource(AlquilerService alquilerService) {
        this.alquilerService = alquilerService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Alquiler>> getAllAlquileres () {
        List<Alquiler> alquileres = alquilerService.findAllAlquileres();
        return new ResponseEntity<>(alquileres, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Alquiler> getAlquilerById (@PathVariable("id") Long id) {
        Alquiler alquiler = alquilerService.findAlquilerById(id);
        return new ResponseEntity<>(alquiler, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Alquiler> addAlquiler(@RequestBody Alquiler alquiler) {
        Alquiler newAlquiler = alquilerService.addAlquiler(alquiler);
        return new ResponseEntity<>(newAlquiler, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Alquiler> updateAlquiler(@RequestBody Alquiler alquiler) {
        Alquiler updateAlquiler = alquilerService.updateAlquiler(alquiler);
        return new ResponseEntity<>(updateAlquiler, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAlquiler(@PathVariable("id") Long id) {
        alquilerService.deleteAlquiler(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
