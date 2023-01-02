package java.com.order.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.com.order.orderservice.dto.OrderRequest;
import java.com.order.orderservice.service.OrderServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/order")
//@RequiredArgsConstructor
public class OrderController {
	@Autowired
	 OrderServiceImpl orderService;
	@PostMapping
	public String placeOrder(@RequestBody OrderRequest orderRequest) {
		orderService.placeOrder(orderRequest);
	return "Order placed successfuly";
	}
}
