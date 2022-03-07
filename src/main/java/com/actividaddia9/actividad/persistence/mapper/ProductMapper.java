package com.actividaddia9.actividad.persistence.mapper;

import com.actividaddia9.actividad.domain.Product;
import com.actividaddia9.actividad.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "precio", target = "price")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> productos);

    @InheritInverseConfiguration
    Producto toProducto(Product product);

}
