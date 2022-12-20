package com.example.block16springcloud.cliente.infraestructura.controller;

import com.example.block16springcloud.cliente.application.ServiceClientImpl;
import com.example.block16springcloud.cliente.domain.dto.ClienteDTO;
import com.example.block16springcloud.cliente.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ControllerCliente {

    @Autowired
    ServiceClientImpl service;

    @PostMapping("/add")
    public ClienteDTO add(@RequestBody Cliente cliente){
        service.save(cliente);
        return cliente.setToDTO();
    }
    @GetMapping("/id/{id}")
    public ClienteDTO findById(@PathVariable Integer id){
        return service.findById(id);
    }
    @GetMapping("/seeAll")
    public List<ClienteDTO> findAll(){
        return service.findAll();
    }
    @PutMapping("/update")
    public ClienteDTO update(@RequestBody Cliente cliente){
        service.save(cliente);
        return cliente.setToDTO();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id){
       if(service.findById(id)!=null) {
           service.delete(id);
           return "Se ha borrado el cliente "+id;
       }
       else {
           return "No se ha encontrado el cliente "+id;
       }
    }
}
