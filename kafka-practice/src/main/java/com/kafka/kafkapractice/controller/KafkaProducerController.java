package com.kafka.kafkapractice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.kafkapractice.service.KafkaProducerService;
import com.kafka.kafkapractice.model.User;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

	private final KafkaProducerService ProducerService;
	
	@Autowired
	public KafkaProducerController(KafkaProducerService ProducerService) {
		this.ProducerService = ProducerService;
	}
	
	@PostMapping(value = "/createUser")
	public String sendMessageToKafkaTopic(
			@RequestParam("userId") long userId,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName) {
		
		User user = User.builder().id(userId).firstName(firstName).lastName(lastName).build();
				
		this.ProducerService.saveCreateUserLog(user);
		
		return "User created, Please check the console";
	}
}
