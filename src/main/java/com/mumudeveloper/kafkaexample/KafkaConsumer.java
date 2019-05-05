package com.mumudeveloper.kafkaexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

	private Logger logger = LoggerFactory.getLogger("Receiver");
	
    @KafkaListener(topics = "topic1")
    public void receiveTopic1(Person person) {
        logger.info("Receiver on topic1: {}", person);
    }

    @KafkaListener(topics = "topic2", groupId = "default")
    public void receiveTopic2(Person person) {
    	logger.info("Receiver on topic2: {}", person);
    }

}
