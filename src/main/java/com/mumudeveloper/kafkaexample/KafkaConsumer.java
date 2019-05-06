package com.mumudeveloper.kafkaexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	private Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
	
    @KafkaListener(topics = "topic1", groupId="group1")
    public void receiveTopic1(Person person) {
        logger.info("Receiver on topic1: {}", person);
    }

    @KafkaListener(topics = "topic2", groupId = "group2")
    public void receiveTopic2(Person person) {
    	logger.info("Receiver on topic2: {}, group: group2", person);
    }
    
    @KafkaListener(topics = "topic2")
    public void receiveTopic2WithoutGroup(Person person) {
    	logger.info("Receiver on topic2: {} without group", person);
    }

}
