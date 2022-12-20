package com.example.block16springcloud2.ticket.infraestructura.repository;

import com.example.block16springcloud2.ticket.domain.entity.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTicket extends CrudRepository<Ticket,Integer> {
}
