package com.example.block16springcloud.viaje.domain.dto;

import com.example.block16springcloud.cliente.domain.dto.ClienteDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ViajeDTO {

    private Integer id_viaje;

    private String origin;

    private String destination;

    private Date departureDate;

    private Date arrivalDate;

    private List<ClienteDTO> passenger;

    private String status;

}
