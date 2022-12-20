package com.example.block16springcloud2.ticket.domain.entity;

import com.example.block16springcloud2.ticket.domain.dto.TicketDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_tickect;

    @Column
    private Integer passengerId;

    @Column
    private String passengerName;

    @Column
    private String passengerSurname;

    @Column
    private String passengerEmail;

    @Column
    private String tripOrigin;

    @Column
    private String tripDestination;

    @Column
    private Date departureDate;

    @Column
    private Date arrivalDate;

    public TicketDTO setToDTO(){
        TicketDTO dto=new TicketDTO();
        dto.setId_tickect(this.id_tickect);
        dto.setPassengerId(this.passengerId);
        dto.setPassengerName(this.passengerName);
        dto.setPassengerSurname(this.passengerSurname);
        dto.setPassengerEmail(this.passengerEmail);
        dto.setTripOrigin(this.tripOrigin);
        dto.setTripDestination(this.tripDestination);
        dto.setDepartureDate(this.departureDate);
        dto.setArrivalDate(this.arrivalDate);
        return dto;
    }
}
