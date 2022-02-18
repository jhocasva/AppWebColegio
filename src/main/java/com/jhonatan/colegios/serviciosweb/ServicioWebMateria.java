package com.jhonatan.colegios.serviciosweb;

import com.jhonatan.colegios.entity.Materia;
import com.jhonatan.colegios.service.ServicioMateria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServicioWebMateria {

    @Autowired
    private ServicioMateria servicioMateria;

    @PostMapping("/materias")
    public String crearMateria(@RequestBody Materia materia){
        String respuesta = servicioMateria.crearMateria(materia);
     return respuesta;
    }

    @GetMapping("/materias/{codigo}")
    public Materia consultarMateriaPorCodigo(@PathVariable  String codigo){
        Materia materia = servicioMateria.consultarMateriaPorCodigo(codigo);
        return  materia;
    }

    @DeleteMapping("/materias/{codigo}")
    public String borrarMateriaPorCodigo(@PathVariable String codigo){
          String respuesta = servicioMateria.borrarMateriaPorCodigo(codigo);
        return respuesta;
    }

    @PutMapping("/materias/{id}")
    public String actualizarMateria(@PathVariable String id, @RequestBody Materia materia){
        String respuesta = servicioMateria.actualizarMateria(id, materia);
        return respuesta;
    }

    /*@GetMapping("/materias")
    public Materia traerMateriaPornombre(@RequestParam String nombre){
       return  respositorioMateria.findByNombre(nombre);
    }*/

    @GetMapping("/materias")
    public List<String> consultarAlumnosRegistradosMateria(@RequestParam String codigoMateria){
        return  servicioMateria.consultarAlumnosRegistradosMateria(codigoMateria);
    }
}
