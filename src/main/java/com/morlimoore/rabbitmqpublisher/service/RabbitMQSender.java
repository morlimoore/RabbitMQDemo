package com.morlimoore.rabbitmqpublisher.service;

import com.morlimoore.rabbitmqpublisher.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate rabbitTemplate2;

    @Value("${rabbitmq.exchange}")
    private String exchange;

    @Value("${rabbitmq.routingkey}")
    private String routingkey;

    public void send(Employee employee) {
        rabbitTemplate2.convertAndSend(exchange, routingkey, employee);
        log.info("Send msg = " + employee);
    }
}
