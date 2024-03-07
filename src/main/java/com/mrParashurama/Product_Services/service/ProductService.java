package com.mrParashurama.Product_Services.service;

import com.mrParashurama.Product_Services.dto.ProductRequest;
import com.mrParashurama.Product_Services.dto.ProductResponse;
import com.mrParashurama.Product_Services.model.Product;
import com.mrParashurama.Product_Services.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private  final ProductRepository productRepository;
    public  void createProduct(ProductRequest productRequest){
        Product product=Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        try {
            productRepository.save(product);
            log.info("product: {} is saved", product.getId());
        }catch (Exception e){
            log.error("error occured in product creation: {}",e.fillInStackTrace());
        }
    }

    public List<ProductResponse> getAllProducts() {
       List<Product> products =productRepository.findAll();
       try {
           return products.stream()
                   .map((product) -> mapToProductResponse(product))//this::mapToProductResponse
                   .collect(Collectors.toList());
       }catch (Exception e){
           log.error("error in getting all products ");
       }
       return new ArrayList<>();
    }
    private ProductResponse mapToProductResponse(Product product){
        ProductResponse productResponse=ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
        log.info("All products all retrived");
        return productResponse;
    }
}
