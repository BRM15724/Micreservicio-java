package com.actividaddia9.actividad.web.controller;

import com.actividaddia9.actividad.domain.Category;
import com.actividaddia9.actividad.domain.service.CategoryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin (origins = "http://localhost:8080")
@RestController
@RequestMapping("/categorias")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("")
    @ApiOperation("Consulta todas las categorias disponibles.")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Category>> getAll(HttpServletRequest request){
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idCategoria}")
    @ApiOperation("Consulta una categoria con un id específico.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No se encontró la categoria con id {idCategoria}")
    })
    public ResponseEntity<Category> getCategory(@PathVariable("idCategoria") int idCategoria){
        return categoryService.getCategory(idCategoria)
                .map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    @ApiOperation("Crea una categoria.")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Category> save(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
    }

    @PutMapping("/{idCategoria}")
    @ApiOperation("Actualiza la categoria con el id: {idCategoria}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No se encontró la categoria con id: {idCategoria}")
    })
    public ResponseEntity<Category> put(@PathVariable("idCategoria") int idCategoria, @RequestBody Category category){
        return categoryService.put(idCategoria, category).map(categoryx -> new ResponseEntity<>(categoryx, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{idCategoria}")
    @ApiOperation("Actualiza parcialmente la categoria con el id:{idCategoria}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No se encontró la categoria con id {idCategoria}")
    })
    public ResponseEntity<Category> patch(@PathVariable("idCategoria") int idCategoria, @RequestBody Category category){
        return categoryService.patch(idCategoria, category).map(categoryx -> new ResponseEntity<>(categoryx, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idCategoria}")
    @ApiOperation("Borra la categoria con el id: {idCategoria}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No se encontro la categoria con id: {idCategoria}")
    })
    public ResponseEntity delete(@PathVariable("idCategoria") int idCategoria){
        if (categoryService.delete(idCategoria)){
            return  new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
