package com.jhonatan.colegios.repositorio;

import com.jhonatan.colegios.entity.Materia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositorioMateria extends CrudRepository<Materia,String> {

     Materia findByNombre(String nombre);

    @Query(value = "select alumno.nombre from materia_alumno\n" +
            "inner join alumno on materia_alumno.idalumno = alumno.identificacion\n" +
            "where  materia_alumno.idmateria = :idmateria", nativeQuery = true)
     List<String> traerAlumnosPorMateria(@Param("idmateria") String idmateria);
}

