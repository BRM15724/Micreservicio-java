package com.actividaddia9.actividad.domain.service;

import com.actividaddia9.actividad.domain.Product;
import com.actividaddia9.actividad.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int idProducto){
        return productRepository.getProduct(idProducto);
    }

    public  Product save(Product product){
        return productRepository.save(product);
    }

    public Optional<Product> put(int idProducto, Product product){
        return productRepository.put(idProducto, product);
    }

    public Optional<Product> patch(int idProducto, Product product){
        return productRepository.patch(idProducto, product);
    }

    public boolean delete(int idProducto){
        return getProduct(idProducto).map(product -> {
            productRepository.delete(idProducto);
            return true;
        }).orElse(false);
    }
}
