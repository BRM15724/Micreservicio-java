package com.actividaddia9.actividad.persistence.mapper;

import com.actividaddia9.actividad.domain.Category;
import com.actividaddia9.actividad.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mappings({
            @Mapping(source = "idCategoria", target = "categoyId"),
            @Mapping(source = "nombre", target = "name")
    })
    Category toCategory(Categoria categoria);
    List<Category> toCategories(List<Categoria> categorias);

    @InheritInverseConfiguration
    Categoria toCategoria(Category category);

}
