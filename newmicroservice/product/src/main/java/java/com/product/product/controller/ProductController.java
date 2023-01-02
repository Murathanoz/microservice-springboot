package com.product.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.product.product.dto.ProductResponse;

import com.product.product.dto.ProductRequest;
import com.product.product.model.Product;
import com.product.product.repository.ProductRepository;
import com.product.product.service.ProductServiceImpl;


@RequestMapping("/api/product")
@RestController
public class ProductController {
	
	@Autowired
	private ProductServiceImpl productService;
@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public void createProduct(@RequestBody ProductRequest productRequest) {
	     try {
	  productService.createProduct(productRequest);
	    	  } 
	     catch (Exception e) {	  
	    	 System.out.println(e);
	    	  }
	}
@GetMapping
@ResponseStatus(HttpStatus.OK)
public List<ProductResponse> findAll() {
	  try {	 
		   return productService.getAllProducts();   
	  } 
	  catch (Exception e) {
	    	 System.out.println(e);
	    return null;
	  }
	}
}
