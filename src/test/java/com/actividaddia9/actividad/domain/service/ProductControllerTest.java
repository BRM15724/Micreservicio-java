package com.actividaddia9.actividad.domain.service;

import com.actividaddia9.actividad.domain.Product;
import com.actividaddia9.actividad.web.controller.ProductController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @Test
    @Order(1)
    public void findByIdProductoTest(){

        ResponseEntity<Product> producto;
        producto = productController.getProduct(2);
        assertEquals("200 OK",producto.getStatusCode().toString());
        producto = productController.getProduct(-1);
        assertEquals("404 NOT_FOUND",producto.getStatusCode().toString());
    }

    @Test
    @Order(2)
    public void saveProductTest(){
        Product product = new Product();
        product.setCategoryId(1);
        product.setName("test");
        product.setPrice(1);
        ResponseEntity<Product> producto = productController.save(product);
        assertNotNull(producto.getBody().getProductId());
    }

    @Test
    @Order(3)
    public void deleteProductTest(){
        //Test de producto no existente que iontenta ser eliminado
        assertEquals("404 NOT_FOUND",productController.delete(-1).getStatusCode().toString());

        //Test de producto existente que es eliminado.
        Product product = new Product();
        product.setCategoryId(1);
        product.setName("test");
        product.setPrice(1.0);
        ResponseEntity<Product> producto = productController.save(product);
        assertEquals("200 OK",productController.delete(producto.getBody().getProductId()).getStatusCode().toString());
    }

    @Test
    @Order(4)
    public void updateProductTest(){
        Product product = new Product();
        product.setCategoryId(1);
        product.setName("test");
        product.setPrice(1.0);
        ResponseEntity<Product> producto = productController.put(2,product);
        assertEquals("200 OK",producto.getStatusCode().toString());
    }

}