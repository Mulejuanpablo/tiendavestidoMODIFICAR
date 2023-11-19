package com.chloe.chloeback.service;

import org.springframework.stereotype.Service;
import com.chloe.chloeback.model.Authresponse;
import com.chloe.chloeback.model.Loginrequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    public Authresponse login(Loginrequest loginrequest) {
        String nombreusuario = "chloe";
        String clave = "vestido";

        if (nombreusuario.equals(loginrequest.getNombreusuario()) && clave.equals(loginrequest.getClave())) {
            return Authresponse.builder().success(true).message("Inicio de sesión exitosa").build();
        } else {
            return Authresponse.builder().success(false).message("Nombre de usuario o contraseña incorrectos").build();
        }
    }
}
