package com.mrParashurama.Product_Services.repository;

import com.mrParashurama.Product_Services.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
