package com.actividaddia9.actividad.domain.service;

import com.actividaddia9.actividad.domain.Category;
import com.actividaddia9.actividad.web.controller.CategoryController;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CategoryControllerTest {

    @Autowired
    private CategoryController categoryController;

    @Test
    @Order(1)
    public void findByIdCategoriaTest(){

        ResponseEntity<Category> category;
        category = categoryController.getCategory(1);
        assertEquals("200 OK",category.getStatusCode().toString());
        category = categoryController.getCategory(-1);
        assertEquals("404 NOT_FOUND",category.getStatusCode().toString());
    }

    @Test
    @Order(2)
    public void saveCategoryTest(){
        Category category = new Category();
        category.setName("test");
        ResponseEntity<Category> categoria = categoryController.save(category);
        assertNotNull(categoria.getBody().getCategoyId());
    }

    @Test
    @Order(3)
    public void deleteCategoryTest(){
        //Test de categoria no existente que iontenta ser eliminado
        assertEquals("404 NOT_FOUND",categoryController.delete(-1).getStatusCode().toString());

        //Test de categoria existente que es eliminado.
        Category category = new Category();
        category.setName("test");
        ResponseEntity<Category> categoria = categoryController.save(category);
        assertEquals("200 OK",categoryController.delete(categoria.getBody().getCategoyId()).getStatusCode().toString());
    }

    @Test
    @Order(4)
    public void updateCategoryTest(){
        Category category = new Category();
        category.setName("test");
        ResponseEntity<Category> categoria = categoryController.put(1,category);
        assertEquals("200 OK",categoria.getStatusCode().toString());
    }

}