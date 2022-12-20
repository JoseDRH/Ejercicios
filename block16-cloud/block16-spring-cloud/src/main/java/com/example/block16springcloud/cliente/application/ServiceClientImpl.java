package com.example.block16springcloud.cliente.application;

import com.example.block16springcloud.cliente.domain.dto.ClienteDTO;
import com.example.block16springcloud.cliente.domain.entity.Cliente;
import com.example.block16springcloud.cliente.infraestructura.repository.RepositoryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceClientImpl {

    @Autowired
    RepositoryClient repo;

    public List<ClienteDTO> findAll(){
        List<ClienteDTO> clientes=new ArrayList<>();
        repo.findAll().forEach(client-> clientes.add(client.setToDTO()));
        return clientes;
    }

    public ClienteDTO findById(Integer id){
        return repo.findById(id).get().setToDTO();
    }
    public void save(Cliente cliente){
        repo.save(cliente);
    }
    public void delete(Integer id){
        repo.deleteById(id);
    }



}
