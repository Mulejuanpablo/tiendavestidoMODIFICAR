// este controlador define los puntos de entrada HTTP para realizar operaciones CRUD en la entidad Vestido y también proporciona un endpoint para manejar la carga de archivos.
package com.chloe.chloeback.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.chloe.chloeback.model.Vestido;
import com.chloe.chloeback.service.VestidoService;

import java.util.List;

//Estas anotaciones definen que esta clase es un controlador Spring MVC y que responde a las solicitudes HTTP con la ruta base /vestido.
@RestController
@RequestMapping("/vestido")
public class VestidoResource {
    private final VestidoService vestidoService;// Se inyecta una instancia de VestidoService en el controlador a través
                                                // del constructor. Esto permite que el controlador utilice los métodos
                                                // proporcionados por VestidoService para interactuar con los datos de
                                                // los vestidos.

    public VestidoResource(VestidoService vestidoService) {
        this.vestidoService = vestidoService;
    }

    // Se definen varios endpoints (@GetMapping, @PostMapping, @PutMapping,
    // @DeleteMapping) para realizar operaciones CRUD en la entidad Vestido
    @GetMapping("/all")
    public ResponseEntity<List<Vestido>> getAllVestidos() {
        List<Vestido> vestidos = vestidoService.findAllVestidos();
        return new ResponseEntity<>(vestidos, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Vestido> getVestidoById(@PathVariable("id") Long id) {
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
    public ResponseEntity<List<Vestido>> searchVestidos(@RequestParam("key") String key) {// : En el método
                                                                                          // searchVestidos, este
                                                                                          // parámetro se utiliza para
                                                                                          // obtener el valor de la
                                                                                          // clave de búsqueda desde la
                                                                                          // URL.
        List<Vestido> vestidos = vestidoService.searchVestidos(key);
        return new ResponseEntity<>(vestidos, HttpStatus.OK);
    }

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<String> handleFileUpload(@RequestParam("file") MultipartFile file) {// El método
                                                                                              // handleFileUpload maneja
                                                                                              // la carga de archivos
                                                                                              // (upload). Utiliza
                                                                                              // MultipartFile para
                                                                                              // recibir el archivo
                                                                                              // desde el cliente.
        try {
            // Guarda el archivo en el servidor o realiza el procesamiento necesario

            // Retorna una respuesta exitosa
            return ResponseEntity.ok("File uploaded successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload file");
        }
    }
}
