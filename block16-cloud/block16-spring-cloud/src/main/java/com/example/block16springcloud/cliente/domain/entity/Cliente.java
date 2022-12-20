package com.example.block16springcloud.cliente.domain.entity;

import com.example.block16springcloud.cliente.domain.dto.ClienteDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_cliente;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String mail;

    @Column
    private int tlfn;



    public ClienteDTO setToDTO(){
        ClienteDTO dto=new ClienteDTO();
        dto.setId_cliente(this.id_cliente);
        dto.setName(this.name);
        dto.setSurname(this.surname);
        dto.setMail(this.mail);
        dto.setTlfn(this.tlfn);
        return dto;
    }
}
