package com.jhonatan.colegios.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Materia {
    @Id
    private String codigo;
    private String nombre;
    private String intensidad_horas;


    public Materia() {
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

    public String getIntensidad_horas() {
        return intensidad_horas;
    }

    public void setIntensidad_horas(String intensidad_horas) {
        this.intensidad_horas = intensidad_horas;
    }


}
