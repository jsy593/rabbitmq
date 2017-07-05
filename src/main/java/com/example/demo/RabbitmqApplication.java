package com.example.demo;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class RabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqApplication.class, args);
	}
	
    //===============以下是验证topic Exchange的队列==========
    @Bean
    public Queue queueForTopicA() {
        return new Queue("topic.A");
    }

    @Bean
    public Queue queueForTopicB() {
        return new Queue("topic.#");
    }
    @Bean
    public Queue queueForTopicC() {
    	return new Queue("topic.C");
    }
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("topic.message");//topic :the name of exchange
    }
    @Bean
    Binding bindingTopicExchangeA(Queue queueForTopicA, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueForTopicA).to(topicExchange).with("topic.A");
    }

    @Bean
    Binding bindingTopicExchangeB(Queue queueForTopicB, TopicExchange topicExchange) {
        return BindingBuilder.bind(queueForTopicB).to(topicExchange).with("topic.#");
    }
    @Bean
    Binding bindingTopicExchangeC(Queue queueForTopicC, TopicExchange topicExchange) {
    	return BindingBuilder.bind(queueForTopicC).to(topicExchange).with("topic.C");
    }
    @Bean
    public Queue queueForDirectA() {
    	return new Queue("direct.A");
    }
    @Bean
    public Queue queueForDirectB() {
    	return new Queue("direct.B");
    }
    @Bean
    DirectExchange directExchange() {
    	return new DirectExchange("direct.message");
    }
    @Bean
    Binding bindingDirectExchangeA(Queue queueForDirectB, DirectExchange directExchange) {
    	return BindingBuilder.bind(queueForDirectB).to(directExchange).with("direct.A");
    }
    @Bean
    Binding bindingDirectExchangeB(Queue queueForDirectA, DirectExchange directExchange) {
    	return BindingBuilder.bind(queueForDirectA).to(directExchange).with("direct.B");
    }
    @Bean
    public Queue queueForFanoutA() {
        return new Queue("fanout.A");
    }

    @Bean
    public Queue queueForFanoutB() {
        return new Queue("fanout.B");
    }

    @Bean
    public Queue queueForFanoutC() {
        return new Queue("fanout.C");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanout.message");
    }

    @Bean
    Binding bindingFanoutExchangeA(Queue queueForFanoutA,FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueForFanoutA).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutExchangeB(Queue queueForFanoutB, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueForFanoutB).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutExchangeC(Queue queueForFanoutC, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(queueForFanoutC).to(fanoutExchange);
    }
    
}
