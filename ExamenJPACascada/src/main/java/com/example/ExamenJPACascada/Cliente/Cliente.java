package com.example.ExamenJPACascada.Cliente;

import com.example.ExamenJPACascada.Cliente.Model.ClienteDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Cliente implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column
    @NotNull
    private String nombre;

    public ClienteDTO setToDTO(){
        ClienteDTO dto=new ClienteDTO();
        dto.setID(this.ID);
        dto.setNombre(this.nombre);
        return dto;
    }

}
