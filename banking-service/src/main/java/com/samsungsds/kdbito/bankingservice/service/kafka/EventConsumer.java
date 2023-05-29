package com.samsungsds.kdbito.bankingservice.service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EventConsumer {

    @KafkaListener(topics = "account", groupId = "kdb")
    public void consume(String message) throws IOException {
        System.out.println(String.format("Consumed message : %s", message));
    }
}
