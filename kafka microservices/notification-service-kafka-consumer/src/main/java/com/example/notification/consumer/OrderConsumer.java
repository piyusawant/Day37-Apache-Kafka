package com.example.notification.consumer;

import com.example.notification.model.Order;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer
{
    @KafkaListener(topics = "order-topic", groupId = "notification-group")
    public void consume(Order order, Acknowledgment ack)
    {
        try
        {
            System.out.println("Notification Received");

            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Product Name: " + order.getProduct());
            System.out.println("Quantity: " + order.getQuantity());

            //Manual commit
            ack.acknowledge();
        } catch (Exception e) {
            System.out.println("Retrying...");
        }

    }
}
