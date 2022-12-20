package com.example.block16springcloud2.cliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Integer id_cliente;

    private String name;

    private String surname;

    private String mail;

    private int tlfn;
}
