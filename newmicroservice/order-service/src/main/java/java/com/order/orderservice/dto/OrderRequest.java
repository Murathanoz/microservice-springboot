package java.com.order.orderservice.dto;

import java.util.List;

import java.com.order.orderservice.model.OrderLineItems;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
private List<OrderLineItemsDto> orderLineItemsDtoList;

}
