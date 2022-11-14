package com.example.ExamenJPACascada.CabeceraFra.Controller;

import com.example.ExamenJPACascada.CabeceraFra.Model.CabeceraFraDTO;
import com.example.ExamenJPACascada.CabeceraFra.Service.ServiceCabeceraFra;
import com.example.ExamenJPACascada.LineasFra.LineasFra;
import com.example.ExamenJPACascada.LineasFra.Service.ServiceLineasFra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/factura")
public class ControllerFacturas {

    @Autowired
    ServiceCabeceraFra service;

    @Autowired
    ServiceLineasFra serviceLineasFra;

    @GetMapping("")
    public List<CabeceraFraDTO> getAll(){
          try {
              return service.findAll();
          }
          catch (Exception e){
              return new ArrayList<>();
          }


    }

    @PostMapping("/linea/{fra}")
    public  CabeceraFraDTO post(@PathVariable Integer fra, @RequestBody LineasFra lin) throws Exception {
           lin.setCabeceraFra(service.findById(fra));
           serviceLineasFra.save(lin);
           return service.findById(fra).setToDTO();



    }
    @DeleteMapping("/{idFra}")
    public String delete(@PathVariable int idFra) throws Exception {
        service.delete(idFra);
        return "Se ha eliminado la factura y sus lineas";

    }


}
