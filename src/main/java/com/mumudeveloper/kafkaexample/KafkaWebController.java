package com.mumudeveloper.kafkaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaWebController {

    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping("/kafka/{topicName}")
    public ResponseEntity<?> sendToTopic(
    		@PathVariable String topicName, 
    		@RequestBody Person person) {
        kafkaProducer.send(topicName, person);
        return ResponseEntity.created(null).build();
    }

}
