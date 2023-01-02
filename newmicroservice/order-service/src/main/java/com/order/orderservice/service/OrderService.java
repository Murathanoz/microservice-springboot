package com.order.orderservice.service;

import com.order.orderservice.dto.OrderRequest;

public interface OrderService {
	void placeOrder(OrderRequest orderRequest);
}
