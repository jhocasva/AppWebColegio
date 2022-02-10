package com.jhonatan.colegios.serviciosweb;

import com.jhonatan.colegios.entity.Materia;
import com.jhonatan.colegios.repositorio.RepositorioMateria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ServicioWebMateria {
    @Autowired
    private RepositorioMateria  respositorioMateria;

    @PostMapping("/materias")
    public String crearMateria(@RequestBody Materia materia){
        String respuesta;
     if(respositorioMateria.existsById(materia.getCodigo())){
         respuesta = "la materia ya existe";
     } else{
         respositorioMateria.save(materia);

         respuesta = "la materia se creó exitosamente";
     }
     return respuesta;
    }

    @GetMapping("/materias/{codigo}")
    public Materia consultarMateriaPorCodigo(@PathVariable  String codigo){
        Optional<Materia> materiaOpt= respositorioMateria.findById(codigo);

        if(materiaOpt.isPresent()){
            return  materiaOpt.get();
        } else{
            return  null;
        }

    }

    @DeleteMapping("/materias/{codigo}")
    public String borrarMateriaPorCodigo(@PathVariable String codigo){
          String respuesta;
        if(respositorioMateria.existsById(codigo)){
            respositorioMateria.deleteById(codigo);
            respuesta = "se borró la materia exitosamente";
        } else {
            respuesta = "no existe una materia con ese codigo";
        }
        return respuesta;
    }

    @PutMapping("/materias")
    public String actualizarMateria(@RequestBody Materia materia){
        String respuesta;

        if(respositorioMateria.existsById(materia.getCodigo())){
           respositorioMateria.save(materia);
           respuesta = "la materia se actualizó correctamente";
        } else {
            respuesta = "la materia no existe";
        }
        return respuesta;
    }

    /*@GetMapping("/materias")
    public Materia traerMateriaPornombre(@RequestParam String nombre){
       return  respositorioMateria.findByNombre(nombre);
    }*/

    @GetMapping("/materias")
    public List<String> consultarAlumnosRegistradosMateria(@RequestParam String codigoMateria){
        return  respositorioMateria.traerAlumnosPorMateria(codigoMateria);
    }



}
