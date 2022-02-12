package com.jhonatan.colegios.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Profesor {

    @Id
    private String cedula;
    private String nombre;
    private String apellido;
    private String edad;
    //private Materia materia;

    public Profesor() {
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

   /* public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }*/
}
