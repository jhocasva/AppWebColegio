package com.jhonatan.colegios.serviciosweb;

import com.jhonatan.colegios.entity.Alumno;
import com.jhonatan.colegios.service.ServicioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServicioWebAlumno {

    @Autowired
    private ServicioAlumno servicioAlumno;

    @PostMapping("/alumnos")
    public String crearAlumno(@RequestBody Alumno alumno){
        String respuesta = servicioAlumno.crearAlumno(alumno);
        return respuesta;
    }

    @GetMapping("/alumnos/{id}")
    public Alumno consultarAlumnoPorId(@PathVariable String id){
        Alumno alumno = servicioAlumno.consultarAlumnoPorId(id);
        return alumno;
    }

    @DeleteMapping("/alumnos/{id}")
    public String  borrarAlumnoPorId(@PathVariable String id){
         String respuesta = servicioAlumno.borrarAlumnoPorId(id);
         return  respuesta;
    }

    @PutMapping("/alumnos/{id}")
    public String actualizarAlumnoPorNombre(@PathVariable  String id,@RequestBody Alumno alumno){
        String respuesta = servicioAlumno.actualizarAlumnoPorNombre(id,alumno);
        return respuesta;
    }

}
