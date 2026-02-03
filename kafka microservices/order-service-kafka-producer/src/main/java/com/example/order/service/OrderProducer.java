package com.example.order.service;

import com.example.order.model.Order;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer
{
    private static final String TOPIC = "order-topic";

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public OrderProducer(KafkaTemplate<String, Object> kafkaTemplate)
    {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrder(Order order)
    {
        kafkaTemplate.send(TOPIC, order);
    }
}
