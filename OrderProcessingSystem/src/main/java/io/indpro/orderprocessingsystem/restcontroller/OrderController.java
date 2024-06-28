package io.indpro.orderprocessingsystem.restcontroller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.indpro.orderprocessingsystem.entity.Order;
import io.indpro.orderprocessingsystem.entity.OrderItem;
import io.indpro.orderprocessingsystem.services.OrderService;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestParam Long userId) {
        Order order = orderService.createOrder(userId);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/{id}/items")
    public ResponseEntity<OrderItem> addItemToOrder(
            @PathVariable Long id,
            @RequestParam Long productId,
            @RequestParam Integer quantity,
            @RequestParam BigDecimal price) {
        OrderItem orderItem = orderService.addItemToOrder(id, productId, quantity, price);
        return ResponseEntity.ok(orderItem);
    }

    @GetMapping("/{id}/total")
    public ResponseEntity<Map> getTotalPrice(@PathVariable Long id) {
        BigDecimal totalPrice = orderService.getTotalPrice(id);
        Map map=new LinkedHashMap<>();
        map.put("order_id", id);
        map.put("total_price", totalPrice);
        return ResponseEntity.ok(map);
    }
    
    @GetMapping("/{id}/items")
    public ResponseEntity<List<OrderItem>> getOrderItems(@PathVariable Long id) {
        List<OrderItem> orderItems = orderService.getOrderItems(id);
        return ResponseEntity.ok(orderItems);
    }  
}

