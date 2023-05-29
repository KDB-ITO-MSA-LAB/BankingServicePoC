package com.samsungsds.kdbito.bankingservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.samsungsds.kdbito.bankingservice.service.kafka.EventProducer;
import com.samsungsds.kdbito.bankingservice.dto.AccountDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final EventProducer producer;

    @Autowired
    KafkaController(EventProducer producer) {
        this.producer = producer;
    }

    @PostMapping
    public String sendMessage(@RequestParam("message") String message) throws JsonProcessingException {
    	
    	AccountDto actDto = new AccountDto((long) 1, "김덕수", "월급통장",1000, message);
    
    	ObjectMapper objectMapper = new ObjectMapper();
    	
    	
        this.producer.sendMessage(objectMapper.writeValueAsString(actDto));
       
        return "success";
    }
}