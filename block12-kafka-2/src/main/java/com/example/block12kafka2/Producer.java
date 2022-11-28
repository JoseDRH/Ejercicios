package com.example.block12kafka2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String TOPIC = "test_topic2";
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMsg(String msg){
        this.kafkaTemplate.send(TOPIC,msg);
    }
}
