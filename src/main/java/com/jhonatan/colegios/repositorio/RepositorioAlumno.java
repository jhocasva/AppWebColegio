package com.jhonatan.colegios.repositorio;

import com.jhonatan.colegios.entity.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioAlumno extends CrudRepository<Alumno,String> {
}
