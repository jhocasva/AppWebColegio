package com.jhonatan.colegios.service;

import com.jhonatan.colegios.entity.Grado;
import com.jhonatan.colegios.repositorio.RepositorioGrado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Service
public class ServicioGrado {

    @Autowired
    private RepositorioGrado repositorioGrado;


    public String crearGrado( Grado grado){
        String respuesta;

        boolean estaONo = repositorioGrado.existsById(grado.getIdgrado());

        if(estaONo){
            respuesta = "el grado a crear ya existe";
        } else{
            repositorioGrado.save(grado);
            respuesta ="el grado se creó exitosamente";
        }
        return  respuesta;
    }


    public String actualizarGrado( Grado grado){

        String respuesta;
        boolean estaONo = repositorioGrado.existsById(grado.getIdgrado());

        if(estaONo){
            repositorioGrado.save(grado);
            respuesta= "el grado se actualizó exitosamente";
        } else {
            respuesta = "el grado a actualizar no existe";
        }
        return  respuesta;
    }

    public Grado consultarGradoPorId(String id){

        Optional<Grado> gradoOp = repositorioGrado.findById(id);

        if(gradoOp.isPresent()){
           return gradoOp.get();
        } else {
           return  null;
        }

    }

    public String borrarGradoPorId(String id){
        String respuesta;
        boolean estaONo = repositorioGrado.existsById(id);
        if(estaONo){
            repositorioGrado.deleteById(id);
           respuesta = "el grado se borro exitosamente";
        } else{
            respuesta = "el grado a borrar no existe";
        }
        return respuesta;

    }

}

