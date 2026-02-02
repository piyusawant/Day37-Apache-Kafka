package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer
{
    private final KafkaTemplate<String, Object>kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order)
    {
        kafkaTemplate.send("order-topic", order.getOrderId(), order);
    }

}
