package com.chloe.chloeback.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Evento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String evento;
    private String fecha;
    private String entrega;
    private String devolucion;

    public Evento() {
    }

    @Override
    public String toString() {
        return "alquilado [id=" + id +
                ", evento=" + evento +
                ", fecha=" + fecha +
                ", entrega=" + entrega +
                ", devolucion=" + devolucion + "]";
    }

    public Long getIdalquilado() {
        return id;
    }

    public void setIdalquilado(Long id) {
        this.id = id;
    }

    public String getEvento() {
        return evento;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

    public String getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(String devolucion) {
        this.devolucion = devolucion;
    }

    public Evento(Long id, String evento, String fecha, String entrega, String devolucion) {
        this.id = id;
        this.evento = evento;
        this.fecha = fecha;
        this.entrega = entrega;
        this.devolucion = devolucion;
    }
}
