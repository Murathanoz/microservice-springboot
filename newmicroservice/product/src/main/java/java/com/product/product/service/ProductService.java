package java.com.product.product.service;

import java.util.List;

import java.com.product.product.dto.ProductRequest;
import java.com.product.product.dto.ProductResponse;

public interface ProductService {
	List<ProductResponse> getAllProducts();
	void createProduct(ProductRequest productRequest);
}
