package com.mumudeveloper.kafkaexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String, Person> kafkaTemplate;
    
    private Logger logger = LoggerFactory.getLogger(KafkaProducer.class);

    public void send(String topic, Person person) {
        kafkaTemplate.send(topic, person);
        logger.info("Message: {} sent to topic {}",person,topic); 
    }
}
