package com.example.block16springcloud.viaje.infraestructura.controller;

import com.example.block16springcloud.viaje.application.ServiceViajeImpl;
import com.example.block16springcloud.viaje.domain.dto.ViajeDTO;
import com.example.block16springcloud.viaje.domain.entity.Viaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerViaje {

    @Autowired
    ServiceViajeImpl service;

    @GetMapping("/trip/seeAll")
    public List<ViajeDTO> findAll(){
        return service.findAll();
    }
    @GetMapping("/trip/id/{id}")
    public ViajeDTO findById(@PathVariable Integer id){
        return service.findById(id);
    }
    @PostMapping("/trip/addTrip")
    public ViajeDTO save(@RequestBody Viaje viaje){
        return service.save(viaje);
    }
    @DeleteMapping("/trip/delete/{idTrip}")
    public String delete(@PathVariable Integer idTrip){
        return service.delete(idTrip);
    }
    @GetMapping("/passenger/count/{id}")
    public String recount(@PathVariable int id){
        return service.recount(id);
    }
    @PutMapping("/trip/addPassenger/{idTrip}/{idPas}")
    public String addPass(@PathVariable Integer idTrip,@PathVariable Integer idPas){
        return service.addPass(idTrip,idPas);
    }
    @PutMapping("/trip/{idtrip}/{statusTrip}")
    public ViajeDTO updateStatus(@PathVariable Integer idtrip,@PathVariable String statusTrip){
        return service.updateStatus(idtrip,statusTrip);
    }
    @GetMapping("/trip/verify/{idTrip}")
    public String getStatus(@PathVariable Integer idTrip){
        return service.getStatus(idTrip);
    }

}
