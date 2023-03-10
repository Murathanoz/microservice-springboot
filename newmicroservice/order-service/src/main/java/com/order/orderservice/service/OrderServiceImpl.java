package com.order.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import com.order.orderservice.dto.InventoryResponse;
import com.order.orderservice.dto.OrderLineItemsDto;
import com.order.orderservice.dto.OrderRequest;
import com.order.orderservice.model.Order;
import com.order.orderservice.model.OrderLineItems;
import com.order.orderservicerepository.OrderRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import java.util.*;
import java.util.stream.*;
@Service
@Transactional
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
	
	private WebClient webClient;
	private  OrderRepository orderRepository;
	public OrderServiceImpl(OrderRepository orderRepository, WebClient webClient) {
		super();
		this.orderRepository = orderRepository;
		this.webClient=webClient;
	}
	
	private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
		OrderLineItems orderLineItems =new OrderLineItems();
		orderLineItems.setPrice(orderLineItemsDto.getPrice());
		orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
		orderLineItems.setCode(orderLineItemsDto.getCode());
		return orderLineItems;
	}

	public void placeOrder(OrderRequest orderRequest) {		
			Order order=new Order();
			order.setOrderNumber(UUID.randomUUID().toString());
			
			List<OrderLineItems> orderLineItems=orderRequest.getOrderLineItemsDtoList()
			.stream()
			.map(this::mapToDto)
			.toList();
			
			 order.setOrderLineItemsList(orderLineItems);
			 
			 List<String> codes=order.getOrderLineItemsList().stream()
			 .map(orderLine->((OrderLineItemsDto) orderRequest.getOrderLineItemsDtoList()).getCode()).toList();
			// call inventory service
			 InventoryResponse[] inventoryResponseArray=webClient.get()
			.uri("http://localhost:8082/api/inventory",uriBuilder->uriBuilder.queryParam( "code", codes).build())
			.retrieve()
			.bodyToMono(InventoryResponse[].class)
			.block();
			 boolean allProductsInStock=Arrays.stream(inventoryResponseArray)
			 .allMatch(inventoryResponse->inventoryResponse.isInStock());
			 
			 
			 if(allProductsInStock) {
					orderRepository.save(order);
			 }
			 else {
				 throw new IllegalArgumentException("Product is not in stock..!");
			 }
		}

}
