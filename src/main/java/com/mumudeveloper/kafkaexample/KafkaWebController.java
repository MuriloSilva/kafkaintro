package com.mumudeveloper.kafkaexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaWebController {

    @Autowired
    KafkaProducer kafkaSender;

    @PostMapping("/kafka/{topicName}")
    public String sendToTopic(@PathVariable String topicName, @RequestBody Person person) {
    	System.out.println(person);
        kafkaSender.send(topicName, person);
        return "Message sent";
    }

}
