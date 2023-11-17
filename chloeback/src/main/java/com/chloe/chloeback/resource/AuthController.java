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
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {

    private final AuthService authService;
    @PostMapping("/login")
        public ResponseEntity<Authresponse> login(@RequestBody Loginrequest loginrequest) {
       return ResponseEntity.ok(authService.login(loginrequest));
    }

    @PostMapping("/registro")
    public ResponseEntity<String> registro(@RequestBody Usuario usuario) {
        // Implementa la lógica para crear un nuevo usuario aquí
        // Puedes almacenar los usuarios en una base de datos o en memoria, según tus necesidades
        return ResponseEntity.ok("Usuario creado exitosamente");
    }
}
