package com.jhonatan.colegios.service;

import com.jhonatan.colegios.entity.Materia;
import com.jhonatan.colegios.repositorio.RepositorioMateria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioMateria {

    @Autowired
    private RepositorioMateria repositorioMateria;

    public String crearMateria( Materia materia){
        String respuesta;
        boolean estaONo = repositorioMateria.existsById(materia.getCodigo());
        if(estaONo){
            respuesta = "la materia ya existe";
        } else{
            repositorioMateria.save(materia);
            respuesta = "la materia se creó exitosamente";
        }
        return respuesta;
    }

    public Materia consultarMateriaPorCodigo(String codigo){
        Optional<Materia> materiaOpt= repositorioMateria.findById(codigo);

        if(materiaOpt.isPresent()){
            return  materiaOpt.get();
        } else{
            return  null;
        }
    }

    public String borrarMateriaPorCodigo(String codigo){
        String respuesta;
        if(repositorioMateria.existsById(codigo)){
            repositorioMateria.deleteById(codigo);
            respuesta = "se borró la materia exitosamente";
        } else {
            respuesta = "no existe una materia con ese codigo";
        }
        return respuesta;
    }

    public String actualizarMateria(String id, Materia materia){
        String respuesta;

        if(repositorioMateria.existsById(id)){
            repositorioMateria.save(materia);
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


    public List<String> consultarAlumnosRegistradosMateria( String codigoMateria){
        return  repositorioMateria.traerAlumnosPorMateria(codigoMateria);
    }
}
