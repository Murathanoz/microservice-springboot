package java.com.order.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.com.order.orderservice.dto.OrderLineItemsDto;
import java.com.order.orderservice.dto.OrderRequest;
import java.com.order.orderservice.model.Order;
import java.com.order.orderservice.model.OrderLineItems;
import java.com.order.orderservicerepository.OrderRepository;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
	//@Autowired
	private  OrderRepository orderRepository;
	public OrderServiceImpl(OrderRepository orderRepository) {
		super();
		this.orderRepository = orderRepository;
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
			
			order.setOrderLineItems(orderLineItems);
			orderRepository.save(order);
		}

}
