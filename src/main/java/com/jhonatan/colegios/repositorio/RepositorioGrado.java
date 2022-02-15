package com.jhonatan.colegios.repositorio;

import com.jhonatan.colegios.entity.Grado;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioGrado extends CrudRepository<Grado,String> {

}
