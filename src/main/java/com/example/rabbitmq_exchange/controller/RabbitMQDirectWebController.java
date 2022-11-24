package com.example.rabbitmq_exchange.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rabbitmq/direct")
public class RabbitMQDirectWebController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @GetMapping("/producer")
    public String producer(
            @RequestParam("exchangeName") String exchange,
            @RequestParam("routingKey") String routingKey,
            @RequestParam("messageData") String messageData
    ) {
        amqpTemplate.convertAndSend(exchange, routingKey, messageData);

        return "Message sent to the RabbitMQ Successfully";
    }
}