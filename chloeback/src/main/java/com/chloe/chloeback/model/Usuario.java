package com.chloe.chloeback.model;

public class Usuario {
    private String nombreusuario;
    private String clave;
    
    public String getNombreusuario() {
        return nombreusuario;
    }
    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }
    public String getClave() {
        return clave;
    }
    public Usuario(String nombreusuario, String clave) {
        this.nombreusuario = nombreusuario;
        this.clave = clave;
    }
    public void setClave(String clave) {
        this.clave = clave;
    }
    
   
   
}
