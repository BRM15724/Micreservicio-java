package com.actividaddia9.actividad.web.controller;

import com.actividaddia9.actividad.domain.Product;
import com.actividaddia9.actividad.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/productos")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("")
    @ApiOperation("Consulta todos los productos disponibles.")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Product>> getAll(HttpServletRequest request){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{idProducto}")
    @ApiOperation("Consulta un producto con un id específico.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No se encontró el producto con id: {idProducto}")
    })
    public ResponseEntity<Product> getProduct(@PathVariable("idProducto") int idProducto){
        return productService.getProduct(idProducto)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    @ApiOperation("Crea un producto.")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @PutMapping("/{idProducto}")
    @ApiOperation("Actualiza el producto con el id: {idProducto}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No se encontró el producto con id: {idProducto}")
    })
    public ResponseEntity<Product> put(@PathVariable("idProducto") int idProducto, @RequestBody Product product){
        return productService.put(idProducto, product).map(productx -> new ResponseEntity<>(productx, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{idProducto}")
    @ApiOperation("Actualiza parcialmente el producto con el id: {idProducto}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No se encontró el producto con id: {idProducto}")
    })
    public ResponseEntity<Product> patch(@PathVariable("idProducto") int idProducto, @RequestBody Product product){
        return productService.patch(idProducto, product).map(productx -> new ResponseEntity<>(productx, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idProducto}")
    @ApiOperation("Borra el producto con el id:{idProducto}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "No se encontró el producto con id: {idProducto}")
    })
    public ResponseEntity delete(@PathVariable("idProducto") int idProducto){
        if (productService.delete(idProducto)){
            return  new ResponseEntity(HttpStatus.OK);
        } else return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

}
