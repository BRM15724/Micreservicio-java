package com.actividaddia9.actividad.domain.service;

import com.actividaddia9.actividad.domain.Category;
import com.actividaddia9.actividad.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int idCategoria){
        return categoryRepository.getCategoria(idCategoria);
    }

    public  Category save(Category category){
        return categoryRepository.save(category);
    }

    public Optional<Category> put(int idCategoria, Category category){
        return categoryRepository.put(idCategoria, category);
    }

    public Optional<Category> patch(int idCategoria, Category category){
        return categoryRepository.patch(idCategoria, category);
    }

    public boolean delete(int idCategoria){
        return getCategory(idCategoria).map(category -> {
            categoryRepository.delete(idCategoria);
            return true;
        }).orElse(false);
    }

}
