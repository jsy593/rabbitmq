package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.sender.HelloSender1;
import com.example.demo.sender.TopicSender;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {
    
    @Autowired
    private HelloSender1 helloSender1;
    @Autowired
    private HelloSender1 helloSender2;
    
    @GetMapping("/hello")
    public void hello() {
        helloSender1.send();
    }
    
	@Autowired
	private TopicSender topicSender;
	
    @GetMapping("/topicTest")
    public void topicTest() {
           topicSender.send();
    }
}
