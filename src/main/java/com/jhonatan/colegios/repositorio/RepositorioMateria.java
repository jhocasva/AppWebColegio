package com.jhonatan.colegios.repositorio;

import com.jhonatan.colegios.entity.Materia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMateria extends CrudRepository<Materia,String> {
}