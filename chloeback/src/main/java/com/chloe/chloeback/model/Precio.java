package com.chloe.chloeback.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Precio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String preciocolor;

    public Precio() {
    }

    @Override
    public String toString() {
        return "precio [id=" + id +
                ", preciocolor=" + preciocolor + "]";
    }

    public Long getIdprecio() {
        return id;
    }

    public void setIdprecio(Long id) {
        this.id = id;
    }

    public String getPreciocolor() {
        return preciocolor;
    }

    public void setPreciocolor(String preciocolor) {
        this.preciocolor = preciocolor;
    }

    public Precio(Long id, String preciocolor) {
        this.id = id;
        this.preciocolor = preciocolor;
    }

}
