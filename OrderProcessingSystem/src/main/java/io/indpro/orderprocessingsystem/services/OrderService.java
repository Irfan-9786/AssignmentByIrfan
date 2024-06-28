package io.indpro.orderprocessingsystem.services;

import java.math.BigDecimal;
import java.util.List;

import io.indpro.orderprocessingsystem.entity.Order;
import io.indpro.orderprocessingsystem.entity.OrderItem;

public interface OrderService {
	     Order createOrder(Long userId);
	    OrderItem addItemToOrder(Long orderId, Long productId, Integer quantity, BigDecimal price);
	    BigDecimal getTotalPrice(Long orderId);
	    List<OrderItem> getOrderItems(Long orderId);
}
