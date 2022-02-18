package com.jhonatan.colegios.service;

import com.jhonatan.colegios.entity.Profesor;
import com.jhonatan.colegios.repositorio.RepositorioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioProfesor {

    @Autowired
    private RepositorioProfesor repositorioProfesor;

    public String crearProfesor( Profesor profesor){
        String respuesta;
        boolean estaONo =  repositorioProfesor.existsById(profesor.getCedula());
        if(estaONo){
            respuesta = "el docente a crear ya existe";
        } else {
            repositorioProfesor.save(profesor);
            respuesta = "el profesor se creó exitosamente";
        }
        return respuesta;
    }

    public String actualizarProfesor(String cedula, Profesor profesor){
        String respuesta;
        Boolean estaONo = repositorioProfesor.existsById(cedula);
        if(estaONo){
            repositorioProfesor.save(profesor);
            respuesta="el profesor se actualizó correctamente";
        } else{
            respuesta = "el profesor a actualizar no existe";
        }
        return respuesta;
    }

    public String borrarProfesorPorCodigo( String cedula){
        String respuesta;
        boolean estaONo = repositorioProfesor.existsById(cedula);
        if(estaONo){
            repositorioProfesor.deleteById(cedula);
            respuesta = "el profesor se borró correctamente";
        } else {
            respuesta = "el profesor no existe ";
        }
        return respuesta;
    }


    public Profesor consultarProfesorPorCc( String cedula){
        Profesor profesor = null;
        Optional<Profesor> profeOp = repositorioProfesor.findById(cedula);
        if(profeOp.isPresent()){
            profesor =  profeOp.get();
        }
        return profesor;
    }

}
