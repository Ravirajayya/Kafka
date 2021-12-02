package com.kafka.kafkapractice.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

import com.kafka.kafkapractice.common.AppConstant;
import com.kafka.kafkapractice.model.User;

@Service
@Slf4j
class KafkaConsumerService {

	@KafkaListener(topics = AppConstant.TOPIC_NAME_USER_LOG, groupId = AppConstant.GROUP_ID)
	public void consume(User user) {
		
		log.info(String.format("User created -> %s", user));
	}
}
