package com.example.orderservice.controller;

import com.example.orderservice.model.Order;
import com.example.orderservice.service.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    private final OrderProducer producer;

    public OrderController(OrderProducer producer)
    {
        this.producer = producer;
    }

    @PostMapping
    public String placeOrder(@RequestBody Order order)
    {
        producer.sendOrder(order);
        return "Order Sent to Kafka";
    }
}
