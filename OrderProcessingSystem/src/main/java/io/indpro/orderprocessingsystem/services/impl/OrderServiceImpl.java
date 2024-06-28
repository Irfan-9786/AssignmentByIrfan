package io.indpro.orderprocessingsystem.services.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.indpro.orderprocessingsystem.entity.Order;
import io.indpro.orderprocessingsystem.entity.OrderItem;
import io.indpro.orderprocessingsystem.repository.OrderItemRepository;
import io.indpro.orderprocessingsystem.repository.OrderRepository;
import io.indpro.orderprocessingsystem.services.OrderService;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public Order createOrder(Long userId) {
		// TODO Auto-generated method stub
		Order order = new Order();
		order.setUser_id(userId);
		order.setCreated_at(new Timestamp(System.currentTimeMillis()));
		order.setTotal_price(BigDecimal.ZERO);
		return orderRepository.save(order);

	}

	@Override
	public OrderItem addItemToOrder(Long orderId, Long productId, Integer quantity, BigDecimal price) {
		// TODO Auto-generated method stub
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + orderId));

		OrderItem orderItem = new OrderItem();
		orderItem.setOrder_id(order.getId());
		orderItem.setProduct_id(productId);
		orderItem.setQuantity(quantity);
		orderItem.setPrice(price);

		order.getItems().add(orderItem);
		BigDecimal totalPrice = order.getTotal_price().add(price.multiply(BigDecimal.valueOf(quantity)));
		order.setTotal_price(totalPrice);

		orderRepository.save(order);
		return orderItemRepository.save(orderItem);

	}

	@Override
	@Transactional(readOnly = true)
	public BigDecimal getTotalPrice(Long orderId) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + orderId));
		return order.getTotal_price();
	}

	@Override
	@Transactional(readOnly = true)
	public List<OrderItem> getOrderItems(Long orderId) {
		Order order = orderRepository.findById(orderId)
				.orElseThrow(() -> new IllegalArgumentException("Order not found with id: " + orderId));
		return order.getItems();
	}

}
