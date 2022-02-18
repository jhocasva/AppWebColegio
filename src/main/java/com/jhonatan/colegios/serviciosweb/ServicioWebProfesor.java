package com.jhonatan.colegios.serviciosweb;

import com.jhonatan.colegios.entity.Profesor;
import com.jhonatan.colegios.service.ServicioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServicioWebProfesor {

    @Autowired
    private ServicioProfesor servicioProfesor;

    @PostMapping("/profesores")
    public String crearProfesor(@RequestBody Profesor profesor){
        String respuesta = servicioProfesor.crearProfesor(profesor);
        return respuesta;
    }

    @PutMapping("/profesores/{cedula}")
    public String actualizarProfesor(@PathVariable String cedula, @RequestBody Profesor profesor){
        String respuesta = servicioProfesor.actualizarProfesor(cedula, profesor);
        return respuesta;
    }

    @DeleteMapping("/profesores/{cedula}")
    public String borrarProfesorPorCodigo(@PathVariable String cedula){
        String respuesta= servicioProfesor.borrarProfesorPorCodigo(cedula);
        return respuesta;
    }

    @GetMapping("/profesores/{cedula}")
    public Profesor consultarProfesorPorCc(@PathVariable String cedula){
        Profesor profesor = servicioProfesor.consultarProfesorPorCc(cedula);
        return profesor;
    }
}
