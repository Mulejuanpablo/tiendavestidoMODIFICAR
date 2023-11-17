package com.chloe.chloeback.model;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String apellido;
    private String nombre;
    private Long dni;
    private Long celular;
    private String mail;
    private String direccion;
    private String ciudad;
     @ManyToMany(mappedBy="clientes")
     private List <Alquiler> alquileres;
    

 
    public Cliente() {}


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public Long getDni() {
        return dni;
    }


    public void setDni(Long dni) {
        this.dni = dni;
    }


    public Long getCelular() {
        return celular;
    }


    public void setCelular(Long celular) {
        this.celular = celular;
    }


    public String getMail() {
        return mail;
    }


    public void setMail(String mail) {
        this.mail = mail;
    }


    public String getDireccion() {
        return direccion;
    }


    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public String getCiudad() {
        return ciudad;
    }


    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }


    @Override
    public String toString() {
        return "Cliente [id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", dni=" + dni + ", celular="
                + celular + ", mail=" + mail + ", direccion=" + direccion + ", ciudad=" + ciudad + "]";
    }


    public Cliente(Long id, String apellido, String nombre, Long dni, Long celular, String mail, String direccion,
            String ciudad) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.celular = celular;
        this.mail = mail;
        this.direccion = direccion;
        this.ciudad = ciudad;
    }

    

}
