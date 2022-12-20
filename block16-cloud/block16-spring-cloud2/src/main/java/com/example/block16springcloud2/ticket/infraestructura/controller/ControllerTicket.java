package com.example.block16springcloud2.ticket.infraestructura.controller;

import com.example.block16springcloud2.ticket.application.ServiceTicketImpl;
import com.example.block16springcloud2.ticket.domain.dto.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerTicket {

    @Autowired
    ServiceTicketImpl service;


    @PostMapping("/generateTicket/{userId}/{tripId}")
    public TicketDTO createTicket(@PathVariable("userId") Integer userId,@PathVariable("tripId") Integer tripId){
       return service.save(tripId,userId);
    }
}
