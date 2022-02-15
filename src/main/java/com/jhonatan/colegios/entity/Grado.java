package com.jhonatan.colegios.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Grado {

    @Id
    private String idgrado;
    private String nombre;

    public Grado(String idgrado, String nombre) {
        this.idgrado = idgrado;
        this.nombre = nombre;
    }

    public Grado() {
    }

    public String getIdgrado() {
        return idgrado;
    }

    public void setIdgrado(String idgrado) {
        this.idgrado = idgrado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
