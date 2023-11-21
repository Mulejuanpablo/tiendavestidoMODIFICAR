//este controlador define endpoints para realizar operaciones relacionadas con la autenticación y el registro de usuarios. El controlador utiliza el servicio AuthService para realizar la lógica de autenticación.

package com.chloe.chloeback.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.chloe.chloeback.model.Authresponse;
import com.chloe.chloeback.model.Loginrequest;
import com.chloe.chloeback.model.Usuario;
import com.chloe.chloeback.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")//Permite solicitudes desde el origen especificado

public class AuthController {

    private final AuthService authService;// Se inyecta una instancia de AuthService en el controlador a través del
                                          // constructor. Esto permite que el controlador utilice los métodos
                                          // proporcionados por AuthService para realizar la autenticación y manejar el
                                          // registro de usuarios.

    // Endpoint para realizar el inicio de sesión

    @PostMapping("/login") // Este endpoint permite realizar el inicio de sesión. Se espera un objeto
                           // Loginrequest en el cuerpo de la solicitud (@RequestBody), y se devuelve una
                           // respuesta de tipo Authresponse que indica si el inicio de sesión fue exitoso
                           // o no.
    public ResponseEntity<Authresponse> login(@RequestBody Loginrequest loginrequest) {
        return ResponseEntity.ok(authService.login(loginrequest));
    }


    @PostMapping("/registro")
    public ResponseEntity<String> registro(@RequestBody Usuario usuario) {
        // Implementa la lógica para crear un nuevo usuario aquí
        // Puedes almacenar los usuarios en una base de datos o en memoria, según tus
        // necesidades

        // Retorna una respuesta exitosa
        return ResponseEntity.ok("Usuario creado exitosamente");
    }
}
