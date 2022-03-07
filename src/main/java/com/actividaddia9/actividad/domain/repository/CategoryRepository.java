package com.actividaddia9.actividad.domain.repository;

import com.actividaddia9.actividad.domain.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

    List<Category> getAll();
    Optional<Category> getCategoria(int idCategoria);
    Category save(Category category);
    Optional<Category> put(int idCategoria, Category category);
    Optional<Category> patch(int idCategoria, Category category);
    void delete(int idCategoria);


}
