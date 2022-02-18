package com.jhonatan.colegios.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Alumno {
    @Id
   private String  identificacion;
   private String nombre;
   private String apellido;
   @ManyToMany
   @JoinTable(
           name= "materia_alumno",
           joinColumns = @JoinColumn(
                   name = "idalumno"
           ),
           inverseJoinColumns = @JoinColumn(
                   name= "idmateria"
           )
   )
   private Set<Materia> materias;

    public Alumno() {
         this.materias = new HashSet<>();
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
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

    public Set<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Set<Materia> materias) {
        this.materias = materias;
    }
}
