package com.kafka.kafkapractice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.kafka.kafkapractice.common.AppConstant;
import com.kafka.kafkapractice.model.User;

@Service
@Slf4j
public class KafkaProducerService {

	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	public void saveCreateUserLog(User user) {
		
		log.info(String.format("User created -> %s", user));
		this.kafkaTemplate.send(AppConstant.TOPIC_NAME_USER_LOG, user);
	}
}
