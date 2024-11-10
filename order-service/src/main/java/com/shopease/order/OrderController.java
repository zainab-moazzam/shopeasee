package com.shopease.order;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private List<Order> orders = new ArrayList<>(Arrays.asList(
        new Order(1, "Laptop", 1200, 1),
        new Order(2, "Phone", 800, 2)
    ));

    @GetMapping
    public List<Order> getAllOrders() {
        return orders;
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        order.setId(orders.size() + 1);
        orders.add(order);
        return order;
    }
}

class Order {
    private int id;
    private String productName;
    private int price;
    private int quantity;

    public Order(int id, String productName, int price, int quantity) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
}
