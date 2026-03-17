package com.balaji.ProductService.services;
import com.balaji.ProductService.thirdpartyclients.fakestore.dtos.FakeStoreProductDto;
import com.balaji.ProductService.dtos.GenericProductDto;

import com.balaji.ProductService.exceptions.NotFoundException;
import com.balaji.ProductService.thirdpartyclients.fakestore.FakeStoreProductClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService{

        private FakeStoreProductClient fakeStoreProductClient;

    @Autowired
    public FakeStoreProductService(FakeStoreProductClient fakeStoreProductClient){

        this.fakeStoreProductClient=fakeStoreProductClient;
    }

    public GenericProductDto convertFakeStoreProductDtoToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        return genericProductDto;
    }
    public FakeStoreProductDto convertGenericProductDtoToFakeStoreProductDto(GenericProductDto genericProductDto){
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(genericProductDto.getId());
        fakeStoreProductDto.setTitle(genericProductDto.getTitle());
        fakeStoreProductDto.setDescription(genericProductDto.getDescription());
        fakeStoreProductDto.setImage(genericProductDto.getImage());
        fakeStoreProductDto.setCategory(genericProductDto.getCategory());
        fakeStoreProductDto.setPrice(genericProductDto.getPrice());
        return fakeStoreProductDto;
    }
    public GenericProductDto getProductById(Long id) throws NotFoundException {

          return convertFakeStoreProductDtoToGenericProductDto(fakeStoreProductClient.getProductById(id));


    }
        public GenericProductDto createProduct(GenericProductDto product){
//        RestTemplate restTemplate = restTemplateBuilder.build();
//        ResponseEntity<FakeStoreProductDto> response = restTemplate.postForEntity(
//                        "https://fakestoreapi.com/products",product,
//                        FakeStoreProductDto.class
//                        );



        return convertFakeStoreProductDtoToGenericProductDto(fakeStoreProductClient.createProduct(product));

    }

    @Override
    public List<GenericProductDto> getAllProducts() {

        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreProductClient.getAllProducts();

        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for (FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){

            GenericProductDto genericProductDto = convertFakeStoreProductDtoToGenericProductDto(fakeStoreProductDto);
            genericProductDtos.add(genericProductDto);
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {

            return convertFakeStoreProductDtoToGenericProductDto(fakeStoreProductClient.deleteProductById(id));

    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {

        FakeStoreProductDto fakeStoreProductDto = convertGenericProductDtoToFakeStoreProductDto(genericProductDto);
        FakeStoreProductDto updated = fakeStoreProductClient.updateProductById(id, fakeStoreProductDto);
        return convertFakeStoreProductDtoToGenericProductDto(updated);
    }

}
