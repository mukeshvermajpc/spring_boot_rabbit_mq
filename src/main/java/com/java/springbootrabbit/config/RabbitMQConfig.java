package com.java.springbootrabbit.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    @Value("${rabbitmq.queue.name}")
    private String name;
    @Value("${rabbitmq.queue.exchange}")
    private String exchange;
    @Value("${rabbitmq.queue.routing.key}")
    private String routingKey;
    //spring bean for getting queue
    @Bean
    public Queue queue() {
        return new Queue(name);
    }

    // spring bean for getting exchange
    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(exchange);
    }

    // Binding between queue and exchange
    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue())
                .to(exchange())
                .with("javaguides_routing_key");
    }
}
