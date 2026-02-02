package com.example.producer.controller;
import com.example.producer.service.MessageProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MessageController
{
    private final MessageProducer producer;

    public MessageController(MessageProducer producer)
    {
        this.producer = producer;
    }

    @PostMapping("/send")
    public String send(@RequestBody String message)
    {
        producer.sendMessage(message);
        return "Message Send to Kafka";
    }
}
