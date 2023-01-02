package com.order.orderservice.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="order_line_items")
public class OrderLineItems {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String code;
private BigDecimal price;
private Integer quantity;


}
