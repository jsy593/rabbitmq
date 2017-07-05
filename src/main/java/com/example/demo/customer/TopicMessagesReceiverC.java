package com.example.demo.customer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.C")
public class TopicMessagesReceiverC {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("topicCReceiver  : " +msg);
    }

}