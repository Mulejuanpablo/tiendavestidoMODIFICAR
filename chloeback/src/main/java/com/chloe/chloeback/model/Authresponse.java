
//esta clase Authresponse se utiliza para representar una respuesta de autenticación. La anotación de Lombok reduce la necesidad de escribir manualmente los métodos comunes en las clases, haciendo el código más conciso y fácil de mantener.
package com.chloe.chloeback.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Authresponse {
    private boolean success;
    private String message;

}
