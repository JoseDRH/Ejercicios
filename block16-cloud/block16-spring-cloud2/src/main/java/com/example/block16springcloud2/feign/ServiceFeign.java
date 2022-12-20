package com.example.block16springcloud2.feign;

import com.example.block16springcloud2.Block16SpringCloud2Application;
import com.example.block16springcloud2.cliente.ClienteDTO;
import com.example.block16springcloud2.viaje.ViajeDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


@FeignClient(name = "Feign", url = "http://"+"${feignhost}"+":8081/")
public interface ServiceFeign {



    @GetMapping("/trip/id/{idTrip}")
    ViajeDTO findByIdTrip(@PathVariable("idTrip") Integer idTrip);

    @GetMapping("/cliente/id/{idPas}")
    ClienteDTO findByIdPass(@PathVariable("idPas") Integer idPas);

    @PutMapping("/trip/addPassenger/{idTrip}/{idPas}")
    String addPass(@PathVariable("idTrip") Integer idTrip,@PathVariable("idPas") Integer idPas);
}
