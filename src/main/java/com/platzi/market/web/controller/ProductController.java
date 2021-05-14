package com.platzi.market.web.controller;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation("Buscar todos los productos")
    @ApiResponse(code = 200, message = "OK")
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @ApiOperation("Obtiene un producto a traves de su id")
    @ApiResponse(code = 200, message = "OK")
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable("productId") long productId){
        return ResponseEntity.of(productService.getProduct(productId));
    }

    @ApiOperation("Obtiene un producto a traves del id de su categoria")
    @ApiResponse(code = 200, message = "OK")
    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") long categoryId){
        return ResponseEntity.of(productService.getByCategory(categoryId));
    }

    @ApiOperation("Guarda un producto nuevo")
    @ApiResponse(code = 200, message = "OK")
    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @ApiOperation("Elimina un producto a traves de su id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Producto no encontrado")
    })
    @DeleteMapping("/{productId}")
    public ResponseEntity delete(@ApiParam(value = "El id del producto", required = true, example = "1")
                                     @PathVariable("productId") long productId){
        if(productService.delete(productId)){
            return new ResponseEntity(HttpStatus.OK);
        }else{
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
