package com.kafka.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class KafkaProducerService {

    @Value(value = "${spring.kafka.topic}")
    private String topic;

    private KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Scheduled(fixedRate = 10000)
    public void sendMessage() {
        UUID uuid = UUID.randomUUID();
        String msg = "Hello World " + uuid.toString();

        ProducerRecord<String, String> record = new ProducerRecord<>(uuid.toString(), msg);

        log.info("KafkaProducerService.sendMessage(): {}", msg);
        kafkaTemplate.send(topic, uuid.toString(), msg);
    }
}
