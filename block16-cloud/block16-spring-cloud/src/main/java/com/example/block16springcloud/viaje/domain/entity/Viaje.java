package com.example.block16springcloud.viaje.domain.entity;

import com.example.block16springcloud.cliente.domain.dto.ClienteDTO;
import com.example.block16springcloud.cliente.domain.entity.Cliente;
import com.example.block16springcloud.viaje.domain.dto.ViajeDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Viaje {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_viaje;

    @Column
    private String origin;

    @Column
    private String destination;

    @Column
    private Date departureDate;

    @Column
    private Date arrivalDate;

    @Column
    @ManyToMany (cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Cliente> passenger;

    @Column
    private String status;


    public ViajeDTO setToDTO(){
        ViajeDTO dto=new ViajeDTO();
        dto.setId_viaje(this.id_viaje);
        dto.setOrigin(this.origin);
        dto.setDestination(this.destination);
        dto.setDepartureDate(this.departureDate);
        dto.setArrivalDate(this.arrivalDate);
        dto.setStatus(this.status);
        List<ClienteDTO>clients=new ArrayList<>();
        passenger.forEach(pas->clients.add(pas.setToDTO()));
        dto.setPassenger(clients);
        return dto;
    }
}
