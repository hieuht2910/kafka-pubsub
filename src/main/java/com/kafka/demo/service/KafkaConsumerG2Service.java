package com.kafka.demo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.listener.AbstractConsumerSeekAware;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumerG2Service extends AbstractConsumerSeekAware {

    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "g2")
    public void listenGroup2(String message) {
        System.out.println("Received Message in group 2: " + message);
    }

//    @KafkaListener(topics = "${spring.kafka.topic}", groupId = "g3")
//    public void listenGroup3(String message) {
//        System.out.println("Received Message in group 3: " + message);
//    }
}
