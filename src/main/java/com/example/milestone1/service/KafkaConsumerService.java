package com.example.milestone1.service;

import com.example.milestone1.constants.AppConstants;
import com.example.milestone1.model.Practitioner;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;

@Service
public class KafkaConsumerService {

    private final Logger logger
            = LoggerFactory.getLogger(KafkaConsumerService.class);

    @KafkaListener(topics = "${general.topic.name}",
            containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) {
        logger.info(String.format("Message recieved -> %s", message));
    }


    @KafkaListener(topics = "${practitioner.topic.name}", containerFactory = "practitionerKafkaListenerContainerFactory")
    public void practitionerListener(Practitioner practitioner) {
        logger.info(String.format("Practitioner created -> %s", practitioner));
    }
}
