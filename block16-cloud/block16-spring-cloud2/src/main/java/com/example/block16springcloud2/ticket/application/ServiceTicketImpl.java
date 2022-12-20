package com.example.block16springcloud2.ticket.application;

import com.example.block16springcloud2.cliente.ClienteDTO;
import com.example.block16springcloud2.feign.ServiceFeign;
import com.example.block16springcloud2.ticket.domain.dto.TicketDTO;
import com.example.block16springcloud2.ticket.domain.entity.Ticket;
import com.example.block16springcloud2.ticket.infraestructura.repository.RepositoryTicket;
import com.example.block16springcloud2.viaje.ViajeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTicketImpl {

    @Autowired
    RepositoryTicket repo;
    @Autowired
    ServiceFeign feign;


    public TicketDTO save(Integer idTrip,Integer idPass){
         Ticket t=new Ticket();
        ViajeDTO dtoTrip=feign.findByIdTrip(idTrip);
        ClienteDTO dtoPass=feign.findByIdPass(idPass);
        t.setPassengerId(idPass);
        t.setPassengerName(dtoPass.getName());
        t.setPassengerSurname(dtoPass.getSurname());
        t.setPassengerEmail(dtoPass.getMail());
        t.setTripOrigin(dtoTrip.getOrigin());
        t.setTripDestination(dtoTrip.getDestination());
        t.setDepartureDate(dtoTrip.getDepartureDate());
        t.setArrivalDate(dtoTrip.getArrivalDate());
        repo.save(t);
        feign.addPass(idTrip,idPass);
         return t.setToDTO();
    }
    public List<TicketDTO> findAll(){
        List<TicketDTO> list=new ArrayList<>();
        repo.findAll().forEach(t->list.add(t.setToDTO()));
        return list;
    }
    public TicketDTO findById(Integer id){
        return repo.findById(id).get().setToDTO();
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }

}
