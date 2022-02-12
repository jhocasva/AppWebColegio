package com.jhonatan.colegios.serviciosweb;

import com.jhonatan.colegios.entity.Profesor;
import com.jhonatan.colegios.repositorio.RepositorioProfesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class ServicioWebProfesor {

    @Autowired
    private RepositorioProfesor repositorioProfesor;

    @PostMapping("/profesores")
    public String crearProfesor(@RequestBody Profesor profesor){
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

    @PutMapping("/profesores")
    public String actualizarProfesor(@RequestBody Profesor profesor){
        String respuesta;
        Boolean estaONo = repositorioProfesor.existsById(profesor.getCedula());
        if(estaONo){
            repositorioProfesor.save(profesor);
            respuesta="el profesor se actualizó correctamente";
        } else{
            respuesta = "el profesor a actualizar no existe";
        }
        return respuesta;
    }

    @DeleteMapping("/profesores/{cedula}")
    public String borrarProfesorPorCodigo(@PathVariable String cedula){
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

    @GetMapping("/profesores/{cedula}")
    public Profesor consultarProfesorPorCc(@PathVariable String cedula){
        Profesor profesor = null;
       Optional<Profesor> profeOp = repositorioProfesor.findById(cedula);
       if(profeOp.isPresent()){
          profesor =  profeOp.get();
       }
        return profesor;
    }
}
