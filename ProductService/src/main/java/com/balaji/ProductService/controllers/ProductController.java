package com.balaji.ProductService.controllers;

import com.balaji.ProductService.dtos.ExceptionDto;
import com.balaji.ProductService.dtos.GenericProductDto;
import com.balaji.ProductService.exceptions.NotFoundException;
import com.balaji.ProductService.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("FakeStoreProductService") ProductService productService){
        this.productService=productService;
    }

//    "products/123"
    @GetMapping("/{id}")
    public ResponseEntity<GenericProductDto> getProductsById(@PathVariable("id") Long id) throws NotFoundException {
        return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
    }

   @PutMapping("/{id}")
    public ResponseEntity<GenericProductDto> updateProductById(@PathVariable("id") Long id, @RequestBody GenericProductDto genericProductDto){
        return new ResponseEntity<>(productService.updateProductById(id, genericProductDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GenericProductDto> createProduct(@RequestBody GenericProductDto genericProductDto){
        return new ResponseEntity<>(productService.createProduct(genericProductDto),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GenericProductDto>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericProductDto> deleteProductById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.deleteProductById(id), HttpStatus.OK);
    }
}
