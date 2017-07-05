package com.example.demo.sender;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send() {
        String msg1 = "I am topic.A";
        this.rabbitTemplate.convertAndSend("topic.message", "topic.A", msg1);//param1:exchange name;param2:queue name
        
        String msg2 = "I am topic.D";
        this.rabbitTemplate.convertAndSend("topic.message", "topic.D", msg2);
    }

}
