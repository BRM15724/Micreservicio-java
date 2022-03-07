package com.actividaddia9.actividad.persistence;

import com.actividaddia9.actividad.domain.Category;
import com.actividaddia9.actividad.domain.repository.CategoryRepository;
import com.actividaddia9.actividad.persistence.crud.CategoriaCrudRepository;
import com.actividaddia9.actividad.persistence.entity.Categoria;
import com.actividaddia9.actividad.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriaRepository implements CategoryRepository {

    @Autowired
    private CategoriaCrudRepository categoriaCrudRepository;

    @Autowired
    private CategoryMapper mapper;

    @Override
    public List<Category> getAll() {
        List<Categoria> categorias = (List<Categoria>) categoriaCrudRepository.findAll();
        return mapper.toCategories(categorias);
    }

    @Override
    public Optional<Category> getCategoria(int idCategoria) {
        return categoriaCrudRepository.findById(idCategoria).map(categoria -> mapper.toCategory(categoria));
    }

    @Override
    public Category save(Category category) {
        Categoria categoria = mapper.toCategoria(category);
        return mapper.toCategory(categoriaCrudRepository.save(categoria));
    }

    @Override
    public Optional<Category> put(int idCategoria, Category category) {
        Categoria categoria = mapper.toCategoria(category);
        categoria.setIdCategoria(idCategoria);
        return Optional.ofNullable(mapper.toCategory(categoriaCrudRepository.save(categoria)));
    }

    @Override
    public Optional<Category> patch(int idCategoria, Category category) {
        return Optional.ofNullable(getCategoria(idCategoria).map(categoryx -> {
            Categoria categoria = mapper.toCategoria(categoryx);
            categoria.setIdCategoria(idCategoria);
            if (category.getName() != null) categoria.setNombre(category.getName());
            return mapper.toCategory(categoriaCrudRepository.save(categoria));
        }).orElse(null));
    }

    @Override
    public void delete(int idCategoria) {
        categoriaCrudRepository.deleteById(idCategoria);
    }
}
