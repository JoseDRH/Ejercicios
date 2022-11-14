package com.example.ExamenJPACascada.LineasFra;

import com.example.ExamenJPACascada.CabeceraFra.CabeceraFra;
import com.example.ExamenJPACascada.CabeceraFra.Model.CabeceraFraDTO;
import com.example.ExamenJPACascada.Cliente.Model.ClienteDTO;
import com.example.ExamenJPACascada.LineasFra.Model.LineasFraDTO;
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
public class LineasFra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;
    @ManyToOne
    @JoinColumn(referencedColumnName = "ID")
    private CabeceraFra cabeceraFra;

    @Column
    @NotNull
    private String ProNomb;

    @Column
    private Double Cantidad;

    @Column
    private Double precio;

    public LineasFraDTO setToDTO(){
        LineasFraDTO dto=new LineasFraDTO();
        dto.setID(this.ID);
        dto.setCantidad(this.Cantidad);
        dto.setProNomb(this.ProNomb);
        dto.setPrecio(this.precio);
        return dto;
    }

}
