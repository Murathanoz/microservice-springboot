package com.product.product.dto;

import java.math.BigDecimal;

import com.product.product.dto.ProductRequest.ProductRequestBuilder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductResponse {
	  private String  id;
	private String name;
	  private String description;
	  private BigDecimal price;
}
