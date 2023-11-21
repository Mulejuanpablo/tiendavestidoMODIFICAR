//define una entidad JPA (Java Persistence API) que representa un vestido
//define la estructura de datos para representar un vestido en la aplicación, con sus atributos y métodos asociados.
package com.chloe.chloeback.model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // Esta anotación indica que esta clase es una entidad JPA, lo que significa que
        // está mapeada a una tabla en la base de datos.
public class Vestido implements Serializable {
    @Id // Estas anotaciones indican que el campo id es la clave primaria de la entidad
        // y que su valor se generará automáticamente (autoincremental).
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false) // Estas anotaciones se utilizan para especificar detalles sobre la
                                                 // columna en la base de datos, como si puede ser nula o si se puede
                                                 // actualizar.
    private Long id;
    @Column(nullable = false, updatable = false)
    private String codigo;
    private String nombre;
    private String color;
    private String talle;
    private String unidades;
    private String fechacompra;
    private String descripcion;
    private String foto;
    private Long precio_id;

    // Getters y setters para acceder y modificar los atributos del vestido
    public Vestido() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTalle() {
        return talle;
    }

    public void setTalle(String talle) {
        this.talle = talle;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public String getFechacompra() {
        return fechacompra;
    }

    public void setFechacompra(String fechacompra) {
        this.fechacompra = fechacompra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Long getPrecio_id() {
        return precio_id;
    }

    public void setPrecio_id(Long precio_id) {
        this.precio_id = precio_id;
    }

    // Método toString para obtener una representación en cadena del objeto
    @Override
    public String toString() {
        return "Vestido [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", color=" + color + ", talle="
                + talle + ", unidades=" + unidades + ", fechacompra=" + fechacompra + ", descripcion=" + descripcion
                + ", foto=" + foto + ", precio_id=" + precio_id + "]";
    }

    // Constructor que inicializa todos los atributos del vestido
    public Vestido(Long id, String codigo, String nombre, String color, String talle, String unidades,
            String fechacompra, String descripcion, String foto, Long precio_id) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.color = color;
        this.talle = talle;
        this.unidades = unidades;
        this.fechacompra = fechacompra;
        this.descripcion = descripcion;
        this.foto = foto;
        this.precio_id = precio_id;
    }

}
