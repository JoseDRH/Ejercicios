package com.example.block12kafka.controller;

import com.example.block12kafka.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Democontroller {

    private final Producer producer;

    @Autowired
    public Democontroller(Producer producer){
        this.producer=producer;
    }
    @PostMapping("/send")
    public void com(@RequestParam("msg") String msg){
        this.producer.sendMsg(msg);
    }
}
