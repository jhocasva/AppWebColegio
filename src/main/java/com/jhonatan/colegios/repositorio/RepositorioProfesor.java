package com.jhonatan.colegios.repositorio;

import com.jhonatan.colegios.entity.Profesor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProfesor extends CrudRepository<Profesor, String> {

}
