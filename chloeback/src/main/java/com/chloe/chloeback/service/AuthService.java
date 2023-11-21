//Este servicio parece ser un servicio de autenticación simple que verifica las credenciales del usuario y devuelve una respuesta de éxito o falla en función de la coincidencia de las credenciales. 

package com.chloe.chloeback.service;

import org.springframework.stereotype.Service;
import com.chloe.chloeback.model.Authresponse;
import com.chloe.chloeback.model.Loginrequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

    // Método para realizar la autenticación de usuario
    public Authresponse login(Loginrequest loginrequest) {// public Authresponse login(Loginrequest loginrequest): Este
                                                          // método realiza la autenticación del usuario comparando las
                                                          // credenciales proporcionadas (nombreusuario y clave) con
                                                          // valores predefinidos ("chloe" y "vestido").
        // Definir un nombre de usuario y una clave de ejemplo
        String nombreusuario = "chloe";
        String clave = "vestido";

        // Comprobar si las credenciales proporcionadas coinciden con las de ejemplo
        if (nombreusuario.equals(loginrequest.getNombreusuario()) && clave.equals(loginrequest.getClave())) {
            // Devolver una respuesta de autenticación exitosa si coinciden
            return Authresponse.builder().success(true).message("Inicio de sesión exitosa").build();// Authresponse.builder()
                                                                                                    // Se utiliza el
                                                                                                    // patrón de diseño
                                                                                                    // del constructor
                                                                                                    // de objetos para
                                                                                                    // construir un
                                                                                                    // objeto
                                                                                                    // Authresponse.
        } else {
            // Devolver una respuesta de autenticación fallida si no coinciden
            return Authresponse.builder().success(false).message("Nombre de usuario o contraseña incorrectos").build();
        }
    }
}
// Si las credenciales coinciden, se devuelve una respuesta de autenticación exitosa con success establecido en true y un mensaje indicando el éxito.

// Si las credenciales no coinciden, se devuelve una respuesta de autenticació fallida con success establecido en false y un mensaje indicando el fallo.