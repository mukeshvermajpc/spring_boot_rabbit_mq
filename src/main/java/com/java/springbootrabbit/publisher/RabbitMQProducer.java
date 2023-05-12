package com.java.springbootrabbit.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQProducer {
    Logger LOGGER= LoggerFactory.getLogger(RabbitMQProducer.class);
    @Value("${rabbitmq.queue.exchange}")
    private String exchange;
    @Value("${rabbitmq.queue.routing.key}")
    private String routingKey;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public void sendMessage(String message){
        LOGGER.info(String.format(String.format("Message sent -> %s",message)));
        rabbitTemplate.convertAndSend(exchange,routingKey,message);
    }
}
