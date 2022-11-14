package com.example.ExamenJPACascada.CabeceraFra.Model;

import com.example.ExamenJPACascada.CabeceraFra.CabeceraFra;
import com.example.ExamenJPACascada.Cliente.Model.ClienteDTO;
import com.example.ExamenJPACascada.LineasFra.Model.LineasFraDTO;
import lombok.Data;

import java.util.List;

@Data
public class CabeceraFraDTO {

    private Integer ID;

    private ClienteDTO id_cliente;

    private Double importeFra;

    private List<LineasFraDTO> lineas;

    public CabeceraFraDTO setToDTO(CabeceraFra ca){
        CabeceraFraDTO dto=new CabeceraFraDTO();
        dto.setID(ca.getID());
        dto.setId_cliente(ca.getId_cliente().setToDTO());
        dto.setImporteFra(ca.getImporteFra());
        dto.setLineas(ca.ListLintoDTO());
        return dto;
    }
}
