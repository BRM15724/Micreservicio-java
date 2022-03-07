package com.actividaddia9.actividad.persistence;

import com.actividaddia9.actividad.domain.Product;
import com.actividaddia9.actividad.domain.repository.ProductRepository;
import com.actividaddia9.actividad.persistence.crud.ProductoCrudRepository;
import com.actividaddia9.actividad.persistence.entity.Producto;
import com.actividaddia9.actividad.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<Product> getProduct(int idProducto) {
        return productoCrudRepository.findById(idProducto).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public Optional<Product> put(int idProducto, Product product) {
        Producto producto = mapper.toProducto(product);
        producto.setIdProducto(idProducto);
        return Optional.ofNullable(mapper.toProduct(productoCrudRepository.save(producto)));
    }

    @Override
    public Optional<Product> patch(int idProducto, Product product) {

        return Optional.ofNullable(getProduct(idProducto).map(productx -> {
            Producto producto = mapper.toProducto(productx);
            producto.setIdProducto(idProducto);
            if (product.getName() != null) producto.setNombre(product.getName());
            return mapper.toProduct(productoCrudRepository.save(producto));
        }).orElse(null));
    }

    @Override
    public void delete(int idProducto) {
        productoCrudRepository.deleteById(idProducto);
    }
}
