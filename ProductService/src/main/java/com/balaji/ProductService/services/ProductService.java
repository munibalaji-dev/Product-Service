package com.balaji.ProductService.services;
import java.util.List;

import com.balaji.ProductService.dtos.GenericProductDto;
import com.balaji.ProductService.exceptions.NotFoundException;

public interface ProductService {
    public GenericProductDto getProductById(Long id) throws NotFoundException;

    public GenericProductDto createProduct(GenericProductDto genericProductDto);

    public List<GenericProductDto> getAllProducts();

    public GenericProductDto deleteProductById(Long id);

    GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto);
}
