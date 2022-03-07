package com.actividaddia9.actividad.persistence.crud;

import com.actividaddia9.actividad.persistence.entity.Categoria;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriaCrudRepository extends CrudRepository<Categoria, Integer> {

    List<Categoria> findByIdCategoria(int idCategoria);


}

