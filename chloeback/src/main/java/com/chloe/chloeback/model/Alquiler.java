package com.chloe.chloeback.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity

public class Alquiler implements Serializable { 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name="alquiler_cliente",
        joinColumns=
            @JoinColumn(name="alquiler_id", referencedColumnName="id"),
        inverseJoinColumns=
            @JoinColumn(name="cliente_id", referencedColumnName="id")
        )
    private List<Cliente> clientes ;

    private Long vestido_id;
    private Long evento_id;
    private String fechaentrega;
    private String fechadevolucion;
    private Long precio;
    private Long seña;
    private Long resto;
   
}
