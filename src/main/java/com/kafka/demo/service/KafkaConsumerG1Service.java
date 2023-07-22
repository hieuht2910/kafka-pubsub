package com.kafka.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AbstractConsumerSeekAware;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerG1Service extends AbstractConsumerSeekAware {

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "g1")
    public void listenGroup1(String message) {
        System.out.println("Received Message in group 1: " + message);
    }
}
