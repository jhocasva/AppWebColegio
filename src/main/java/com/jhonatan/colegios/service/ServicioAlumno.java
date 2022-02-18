package com.jhonatan.colegios.service;

import com.jhonatan.colegios.entity.Alumno;
import com.jhonatan.colegios.repositorio.RepositorioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServicioAlumno {

    @Autowired
    private RepositorioAlumno repositorioAlumno;

    public String crearAlumno( Alumno alumno){
        String respuesta;
        Optional<Alumno> alumnoEncontrado = repositorioAlumno.findById(alumno.getIdentificacion());
        if(!alumnoEncontrado.isPresent()){
            repositorioAlumno.save(alumno);
            respuesta= "se creó un alumno exitosamente";
        } else{
            respuesta = "ya existe un usuario con esa identificacion";
        }
        return respuesta;
    }

    public Alumno consultarAlumnoPorId(String id){
        Optional<Alumno> alumnoOpt = repositorioAlumno.findById(id);
        if(alumnoOpt.isPresent()){
            return alumnoOpt.get();
        }else{
            return null;
        }
    }

    public String  borrarAlumnoPorId( String id){
        String respuesta;
        Optional<Alumno> alumnoAborrar =  repositorioAlumno.findById(id);
        if(alumnoAborrar.isPresent()){
            repositorioAlumno.deleteById(id);
            respuesta = " el alumno se borró exitosamente";
        } else{
            respuesta = "el alumno no existe";
        }
        return respuesta;
    }

    public String actualizarAlumnoPorNombre(String id, Alumno alumno){
        Optional<Alumno> alumnoOptional= repositorioAlumno.findById(id);
        String respuesta;
        if(alumnoOptional.isPresent()){
            repositorioAlumno.save(alumno);
            respuesta ="el alumno se actualizó correctamente";
        } else{
            respuesta = "el alumno no existe";
        }
        return respuesta;
    }


}
