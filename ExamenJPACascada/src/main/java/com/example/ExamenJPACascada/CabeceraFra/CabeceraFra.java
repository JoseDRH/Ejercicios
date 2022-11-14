package com.example.ExamenJPACascada.CabeceraFra;

import com.example.ExamenJPACascada.CabeceraFra.Model.CabeceraFraDTO;
import com.example.ExamenJPACascada.Cliente.Cliente;
import com.example.ExamenJPACascada.Cliente.Model.ClienteDTO;
import com.example.ExamenJPACascada.LineasFra.LineasFra;
import com.example.ExamenJPACascada.LineasFra.Model.LineasFraDTO;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class CabeceraFra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;


    @OneToOne
    @JoinColumn(referencedColumnName = "ID")
    private Cliente id_cliente;

    @Column
    @NotNull
    private Double importeFra;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "cabeceraFra")
    private List<LineasFra> lineas;

    public List<LineasFraDTO> ListLintoDTO(){
        List<LineasFraDTO> lista=new ArrayList<>();
        lineas.forEach(lineasFra -> lista.add(lineasFra.setToDTO()));
        return lista;
    }
    public CabeceraFraDTO setToDTO(){
        CabeceraFraDTO dto=new CabeceraFraDTO();
        dto.setID(this.ID);
        dto.setId_cliente(this.id_cliente.setToDTO());
        dto.setImporteFra(this.importeFra);
        dto.setLineas(ListLintoDTO());
        return dto;
    }




}
