package com.jhonatan.colegios.serviciosweb;

import com.jhonatan.colegios.entity.Grado;
import com.jhonatan.colegios.repositorio.RepositorioGrado;
import com.jhonatan.colegios.service.ServicioGrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ServicioWebGrado {

    @Autowired
    private ServicioGrado servicioGrado;

    @PostMapping("/grados")
    public String crearGrado(@RequestBody Grado grado){
        String respuesta = servicioGrado.crearGrado(grado);
        return respuesta;
    }

    @PutMapping("/grados")
    public String actualizarGrado(@RequestBody Grado grado){
        String respuesta = servicioGrado.actualizarGrado(grado);
        return  respuesta;
    }

    @GetMapping("/grados/{id}")
    public Grado consultarGradoPorId(@PathVariable  String id){
      Grado grado =  servicioGrado.consultarGradoPorId(id);
      return  grado;
    }

    @DeleteMapping("/grados/{id}")
    public String borrarGradoPorId(@PathVariable  String id){
        String respuesta = servicioGrado.borrarGradoPorId(id);
        return respuesta;
    }

}
