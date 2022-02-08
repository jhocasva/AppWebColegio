package com.jhonatan.colegios.serviciosweb;

import com.jhonatan.colegios.entity.Alumno;
import com.jhonatan.colegios.repositorio.RepositorioAlumno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class
ServicioWebAlumno {
    @Autowired
    private RepositorioAlumno repositorioAlumno;

    @PostMapping("/alumnos")
    public String crearAlumno(@RequestBody Alumno alumno){
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

    @GetMapping("/alumnos/{id}")
    public Alumno consultarAlumnoPorId(@PathVariable String id){
        Optional<Alumno> alumnoOpt = repositorioAlumno.findById(id);
        if(alumnoOpt.isPresent()){
            return alumnoOpt.get();
        }else{
            return null;
        }
    }

    @DeleteMapping("/alumnos/{id}")
    public void borrarAlumnoPorId(@PathVariable String id){
      Optional<Alumno> alumnoAborrar =  repositorioAlumno.findById(id);
      if(alumnoAborrar.isPresent()){
          repositorioAlumno.deleteById(id);
      }
    }

    @PutMapping("/alumnos/{id}")
    public String actualizarAlumnoPorNombre(@PathVariable  String id,@RequestBody String nombre){
        Optional<Alumno> alumnoOptional= repositorioAlumno.findById(id);
        String respuesta;
        if(alumnoOptional.isPresent()){
            Alumno alumno= alumnoOptional.get();
            alumno.setNombre(nombre);
            repositorioAlumno.save(alumno);
            respuesta ="el alumno se actualizó correctamente";
        } else{
            respuesta = "el alumno no existe";
        }
        return respuesta;
    }

}
