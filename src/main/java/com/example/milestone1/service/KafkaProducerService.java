package com.example.milestone1.service;

import com.example.milestone1.model.Practitioner;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.kafka.support.SendResult;

@Service
public class KafkaProducerService {

    private static final Logger logger =
            LoggerFactory.getLogger(KafkaProducerService.class);

    @Value(value = "${general.topic.name}")
    private String topicName;

    @Autowired
    public KafkaTemplate<String, String>kafkaTemplate;

    @Value(value = "${practitioner.topic.name}")
    private String practitionerTopicName;

    @Autowired
    private KafkaTemplate<String, Practitioner> practitionerKafkaTemplate;

    /*
    public void saveCreatedPractitionerLog(Practitioner practitioner){
        logger.info(String.format("Practitioner created -> %s", practitioner));
        this.kafkaTemplate.send(AppConstants.TOPIC_NAME_PRACTITIONER_LOG, practitioner);
    }
    */

    public void sendMessage(String message){
        ListenableFuture<SendResult<String, String>> future
                = this.kafkaTemplate.send(topicName, message);

        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("Unable to send message : " + message, ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                logger.info("Sent message: " + message
                        + " with offset: " + result.getRecordMetadata().offset());

            }
        });
    }

    public void saveCreatedPractitionerLog(Practitioner practitioner){
        ListenableFuture<SendResult<String,Practitioner>> future = this.practitionerKafkaTemplate.send(practitionerTopicName, practitioner);

        future.addCallback(new ListenableFutureCallback<SendResult<String, Practitioner>>() {
            @Override
            public void onFailure(Throwable ex) {
                logger.error("Practitioner created  ex: " + practitioner, ex);
            }

            @Override
            public void onSuccess(SendResult<String, Practitioner> result) {
                logger.info("Practitioner created: "
                        + practitioner + " with offset: " + result.getRecordMetadata().offset());

            }
        });

        //logger.info(String.format("Practitioner created -> %s", practitioner));
        //this.kafkaTemplate.send(AppConstants.TOPIC_NAME_PRACTITIONER_LOG, practitioner);
    }
}
