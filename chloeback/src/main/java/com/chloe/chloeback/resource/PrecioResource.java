package com.chloe.chloeback.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.chloe.chloeback.model.Precio;
import com.chloe.chloeback.service.PrecioService;

import java.util.List;

@RestController
@RequestMapping("/precio")
public class PrecioResource {
    private final PrecioService precioService;

    public PrecioResource(PrecioService precioService) {
        this.precioService = precioService;
    }

    @GetMapping("/allprecio")
    public ResponseEntity<List<Precio>> getAllPrecios () {
        List<Precio> precios = precioService.findAllPrecios();
        return new ResponseEntity<>(precios, HttpStatus.OK);
    }

    @GetMapping("/findprecio/{id}")
    public ResponseEntity<Precio> getPrecioById (@PathVariable("id") Long id) {
        Precio precio = precioService.findPrecioById(id);
        return new ResponseEntity<>(precio, HttpStatus.OK);
    }

    @PostMapping("/addprecio")
    public ResponseEntity<Precio> addPrecio(@RequestBody Precio precio) {
        Precio newPrecio = precioService.addPrecio(precio);
        return new ResponseEntity<>(newPrecio, HttpStatus.CREATED);
    }

    @PutMapping("/updateprecio")
    public ResponseEntity<Precio> updatePrecio(@RequestBody Precio precio) {
        Precio updatePrecio = precioService.updatePrecio(precio);
        return new ResponseEntity<>(updatePrecio, HttpStatus.OK);
    }

    @DeleteMapping("/deleteprecio/{id}")
    public ResponseEntity<?> deletePrecio(@PathVariable("id") Long id) {
        precioService.deletePrecio(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
