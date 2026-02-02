package com.example.consumerservice.consumer;
import com.example.order.model.Oder;
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
            System.out.println("Received Order: " +order.getOrderId);
        }
    }
}
