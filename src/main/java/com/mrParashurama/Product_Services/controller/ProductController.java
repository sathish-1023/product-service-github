package com.mrParashurama.Product_Services.controller;

import com.mrParashurama.Product_Services.dto.ProductRequest;
import com.mrParashurama.Product_Services.dto.ProductResponse;
import com.mrParashurama.Product_Services.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product")
public class ProductController {

    private final ProductService productService;
    @PostMapping("/createproduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
    }
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse>getAllProducts(){

        return productService.getAllProducts();
    }

}
