package com.example.milestone1.kafka;

import com.example.milestone1.constants.AppConstants;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${kafka.bootstrapAddress}")
    private String bootstrapAddress;

    @Value(value = "${general.topic.name}")
    private String topicName;

    @Value(value = "${practitioner.topic.name}")
    private String practitionerTopicName;


    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }

    @Bean
    public NewTopic topic1() {
        return new NewTopic(topicName,1, (short) 1);
    }

    @Bean
    public NewTopic topic2() {
        return new NewTopic(practitionerTopicName,1, (short) 1);
    }

    @Bean
    public NewTopic topic3() {
        return new NewTopic(AppConstants.TOPIC_NAME_PRACTITIONER_LOG,1, (short) 1);
    }
}
