package com.product.product.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(collection="product")
public class Product {
	@Transient
    public static final String SEQUENCE_NAME = "products_sequence";
  @Id
  private String  id;
  private String name;
  private String description;
  private BigDecimal price;

 
}
