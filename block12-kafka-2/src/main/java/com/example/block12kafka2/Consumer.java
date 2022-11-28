package com.example.block12kafka2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    @Autowired
    Producer producer;

    @KafkaListener(topics="test_topic",groupId = "group_id")
    public void consumeMsg(String msg){

        System.out.println(msg);
        producer.sendMsg("Mensaje recibido");
    }
}
