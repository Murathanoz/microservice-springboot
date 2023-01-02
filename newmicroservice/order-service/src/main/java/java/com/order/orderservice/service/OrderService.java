package java.com.order.orderservice.service;

import java.com.order.orderservice.dto.OrderRequest;

public interface OrderService {
	void placeOrder(OrderRequest orderRequest);
}
