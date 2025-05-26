package com.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Product;
import com.nt.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	private final ProductService ProductService;
	
	public ProductController(ProductService ProductService)
	{
		this.ProductService=ProductService;
	}
	
	@PostMapping
	public Product createProduct(@RequestBody Product Product)
	{
		return ProductService.createProduct(Product);
	}
	
	@GetMapping
    public List<Product> getAllProducts()
    {
    	return ProductService.getAllProducts();
    }
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable Integer Id)
	{
		return ProductService.getProductById(Id)
				.orElseThrow(()-> new RuntimeException("Product Not found"));
				
	}
    
}
