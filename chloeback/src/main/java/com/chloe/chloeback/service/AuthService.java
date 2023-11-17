package com.chloe.chloeback.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.chloe.chloeback.model.Authresponse;
import com.chloe.chloeback.model.Loginrequest;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {
    
    public Authresponse login(Loginrequest loginrequest ){
        String nombreusuario = "chloe";
        String clave = "vestido";
         if (nombreusuario.equals(loginrequest.getNombreusuario()) && clave.equals(loginrequest.getClave())) {
             return Authresponse.builder()
        .respuesta("inicio de sesion exitosa").build();
        } // else {
        //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        // }
        return Authresponse.builder()
         .respuesta("No inicio de sesion exitosa").build();
    }

}
