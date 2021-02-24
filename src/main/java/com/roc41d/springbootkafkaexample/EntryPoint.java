package com.roc41d.springbootkafkaexample;

import com.roc41d.springbootkafkaexample.service.KafkaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class EntryPoint {

    @Autowired
    KafkaService kafkaService;

    private static final Logger LOG = LogManager.getLogger();

    public void start() {
        LOG.info("APP STARTED");
    }

    @KafkaListener(topics = "topic-name", groupId = "topicGroup")
    public void riskRequestGroupListener(String msg) {
        LOG.info("[NEW_MESSAGE: {}]", msg);
    }
}
