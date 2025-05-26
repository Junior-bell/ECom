package com.nt.service;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.model.Product;
import com.repo.ProductRepo;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product createProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Integer Id) {
        return productRepo.findById(Id);
    }
}