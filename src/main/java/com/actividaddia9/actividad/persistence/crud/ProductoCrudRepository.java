package com.actividaddia9.actividad.persistence.crud;

import com.actividaddia9.actividad.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

    List<Producto> findByIdProducto(int idProducto);

}
