package com.kafka.demo.controller;

import com.kafka.demo.service.KafkaConsumerG1Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    private KafkaConsumerG1Service kafkaConsumerG1Service;

    public ConsumerController(KafkaConsumerG1Service kafkaConsumerG1Service) {
        this.kafkaConsumerG1Service = kafkaConsumerG1Service;
    }

    @RequestMapping(value = "/g1/seek-to-begin", method = RequestMethod.GET)
    public ResponseEntity<Boolean> seekToBegin() {
        kafkaConsumerG1Service.seekToBeginning();
        return ResponseEntity.ok(true);
    }
}
