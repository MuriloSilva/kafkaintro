package com.mumudeveloper.kafkaexample;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class ProducerConfig {

  @Value("${spring.kafka.bootstrap-servers}")
  private String bootstrapServers;
  
  @Value("${spring.kafka.producer.key-serializer}")
  private String keySerializerClass;
  
  @Value("${spring.kafka.producer.value-serializer}")
  private String valueSerializerClass;

  @Bean
  public Map<String, Object> producerConfigs() {
    Map<String, Object> props = new HashMap<>();
    props.put(org.apache.kafka.clients.producer.ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
    props.put(org.apache.kafka.clients.producer.ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializerClass);
    props.put(org.apache.kafka.clients.producer.ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializerClass);

    return props;
  }

  @Bean
  public ProducerFactory<String, Person> producerFactory() {
    return new DefaultKafkaProducerFactory<>(producerConfigs());
  }

  @Bean
  public KafkaTemplate<String, Person> kafkaTemplate() {
    return new KafkaTemplate<>(producerFactory());
  }
}