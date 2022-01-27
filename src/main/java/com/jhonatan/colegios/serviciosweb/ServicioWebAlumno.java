package com.jhonatan.colegios.serviciosweb;

import com.jhonatan.colegios.entity.Alumno;
import com.jhonatan.colegios.repositorio.RepositorioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServicioWebAlumno {
    @Autowired
    private RepositorioAlumno repositorioAlumno;

    public String crearAlumno(Alumno alumno){
        repositorioAlumno.save(alumno);
        String respuesta= "se creó un alumno exitosamente";
        return respuesta;
    }

    public Alumno consultarAlumnoPorId(String id){
        Alumno alumno= repositorioAlumno.findById(id).get();
        return alumno;
    }

    public void borrarAlumnoPorId(String id){
        repositorioAlumno.deleteById(id);
    }

    public String actualizarAlumnoPorNombre(String id,String nombre){
        Alumno alumno= repositorioAlumno.findById(id).get();
        alumno.setNombre(nombre);
        repositorioAlumno.save(alumno);
        return "el alumno se actualizó correctamente";
    }

}
