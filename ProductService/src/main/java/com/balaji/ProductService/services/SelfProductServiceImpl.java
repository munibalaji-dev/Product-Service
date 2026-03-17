package com.balaji.ProductService.services;

import com.balaji.ProductService.dtos.GenericProductDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("SelfProductServiceImpl")
public class SelfProductServiceImpl implements ProductService {
    public GenericProductDto getProductById(Long id) {
        System.out.println("Calling from SelfProductImpl");

        return null;
    }
        public GenericProductDto createProduct(GenericProductDto genericProductDto){
            return null;
    }
    public List<GenericProductDto> getAllProducts(){
        return null;
    }
    public GenericProductDto deleteProductById(Long id){
        return null;
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        return null;
    }
}
