package com.balaji.ProductService.thirdpartyclients.fakestore;

import com.balaji.ProductService.repositories.ProductRepository;
import com.balaji.ProductService.thirdpartyclients.fakestore.dtos.FakeStoreProductDto;
import com.balaji.ProductService.dtos.GenericProductDto;
import com.balaji.ProductService.exceptions.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class FakeStoreProductClient {

//    @Value("${fakestore.api.baseUrl}")
//    private String fakeStoreApiBaseUrl;
//
//    @Value("${fakestore.api.product}")
//    private String fakeStoreProductPath;

//    private String getProductByIdUrl = fakeStoreApiBaseUrl+fakeStoreProductPath+"{id}";
//    private String createProductUrl = fakeStoreApiBaseUrl+fakeStoreProductPath;
//    private String allProductsUrl = fakeStoreApiBaseUrl+fakeStoreProductPath;
//    private String deleteproductUrl = fakeStoreApiBaseUrl+fakeStoreProductPath+"{id}";

    private static final String BASE_URL = "https://fakestoreapi.com/products";
    private String GET_PRODUCT = BASE_URL+"/{id}";
    private String CREATE_PRODUCT = BASE_URL;
    private String GETALL_PRODUCTS = BASE_URL;
    private String DELETE_PRODUCT = BASE_URL + "/{id}";
    private String UPDATE_PRODUCT = BASE_URL+ "/{id}";

    private ProductRepository productRepository;

    private RestTemplateBuilder restTemplateBuilder;

     public FakeStoreProductClient(RestTemplateBuilder restTemplateBuilder,
                                   ProductRepository productRepository){
         this.restTemplateBuilder=restTemplateBuilder;
         this.productRepository = productRepository;
     }

    public FakeStoreProductDto getProductById(Long id) throws NotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(
                GET_PRODUCT,
                FakeStoreProductDto.class,
                id);

        FakeStoreProductDto fakeStoreProductDto = response.getBody();

        if (fakeStoreProductDto == null){
            throw new NotFoundException("Product with id "+ id +" not found");
        }
        return fakeStoreProductDto;

    }
    public FakeStoreProductDto createProduct(GenericProductDto product){

        RestTemplate restTemplate = restTemplateBuilder.build();

        FakeStoreProductDto request = new FakeStoreProductDto();
        request.setTitle(product.getTitle());
        request.setPrice(product.getPrice());
        request.setDescription(product.getDescription());
        request.setCategory(product.getCategory());
        request.setImage(product.getImage());

        ResponseEntity<FakeStoreProductDto> response =
                restTemplate.postForEntity(
                        CREATE_PRODUCT,
                        request,
                        FakeStoreProductDto.class
                );

        FakeStoreProductDto fakeStoreProductDto =response.getBody();


        return fakeStoreProductDto;
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto[]> response = restTemplate.getForEntity(
                GETALL_PRODUCTS,
                FakeStoreProductDto[].class);

        FakeStoreProductDto[] fakeStoreProductDtos = response.getBody();


        return Arrays.asList(fakeStoreProductDtos);
    }


    public FakeStoreProductDto deleteProductById(Long id) {


        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(
                DELETE_PRODUCT,
                HttpMethod.DELETE,
                null,
                FakeStoreProductDto.class,
                id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();


        return fakeStoreProductDto;
    }

    public FakeStoreProductDto updateProductById(Long id, FakeStoreProductDto fakeStoreProductDto) {
        HttpEntity<FakeStoreProductDto> request = new HttpEntity<>(fakeStoreProductDto);

         RestTemplate restTemplate = restTemplateBuilder.build();
         ResponseEntity<FakeStoreProductDto> response = restTemplate.exchange(
               UPDATE_PRODUCT,
               HttpMethod.PUT,
                 request,
                 FakeStoreProductDto.class,
                 id
         );

         FakeStoreProductDto fakeStoreProductDto1 = response.getBody();
         return fakeStoreProductDto;
    }
}
