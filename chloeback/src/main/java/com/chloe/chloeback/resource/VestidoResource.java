package com.chloe.chloeback.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.chloe.chloeback.model.Vestido;
import com.chloe.chloeback.service.VestidoService;

import java.util.List;

@RestController
@RequestMapping("/vestido")
public class VestidoResource {
    private final VestidoService vestidoService;

    public VestidoResource(VestidoService vestidoService) {
        this.vestidoService = vestidoService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Vestido>> getAllVestidos () {
        List<Vestido> vestidos = vestidoService.findAllVestidos();
        return new ResponseEntity<>(vestidos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Vestido> getVestidoById (@PathVariable("id") Long id) {
        Vestido vestido = vestidoService.findVestidoById(id);
        return new ResponseEntity<>(vestido, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Vestido> addVestido(@RequestBody Vestido vestido) {
        Vestido newVestido = vestidoService.addVestido(vestido);
        return new ResponseEntity<>(newVestido, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Vestido> updateVestido(@RequestBody Vestido vestido) {
        Vestido updateVestido = vestidoService.updateVestido(vestido);
        return new ResponseEntity<>(updateVestido, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteVestido(@PathVariable("id") Long id) {
        vestidoService.deleteVestido(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping("/search")
public ResponseEntity<List<Vestido>> searchVestidos(@RequestParam("key") String key) {
    List<Vestido> vestidos = vestidoService.searchVestidos(key);
    return new ResponseEntity<>(vestidos, HttpStatus.OK);
}

}
