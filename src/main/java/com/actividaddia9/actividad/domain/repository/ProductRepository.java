package com.actividaddia9.actividad.domain.repository;

import com.actividaddia9.actividad.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    List<Product> getAll();
    Optional<Product> getProduct(int idProducto);
    Product save(Product product);
    Optional<Product> put(int idProducto, Product product);
    Optional<Product> patch(int idProducto, Product product);
    void delete(int idProducto);

}
