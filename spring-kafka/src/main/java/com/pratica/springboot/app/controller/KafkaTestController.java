package com.pratica.springboot.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratica.springboot.app.producer.KafkaMessageProducer;

@RestController
public class KafkaTestController {
	
	@Autowired
	KafkaMessageProducer kafkaMessageProducer;
	
	@PostMapping("/add/{topic}")
	public void addIdCustomer( @PathVariable String topic,@RequestBody  String body)
	{
		kafkaMessageProducer.sendMessage(topic);
	}

}