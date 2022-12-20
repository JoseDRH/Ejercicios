package com.example.block16springcloud.viaje.application;

import com.example.block16springcloud.cliente.domain.entity.Cliente;
import com.example.block16springcloud.cliente.infraestructura.repository.RepositoryClient;
import com.example.block16springcloud.viaje.domain.dto.ViajeDTO;
import com.example.block16springcloud.viaje.domain.entity.Viaje;
import com.example.block16springcloud.viaje.infraestructura.repository.RepositoryViaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceViajeImpl {

    @Autowired
    RepositoryViaje repo;

    @Autowired
    RepositoryClient  repoPas;


    public String addPass(Integer idTrip,Integer idPas){

        Viaje trip=repo.findById(idTrip).get();
        List<Cliente> list=trip.getPassenger();
        if (list.size()<40) {
            list.add(repoPas.findById(idPas).get());
            trip.setPassenger(list);
            repo.save(trip);
            return "El pasajero "+idPas+" compro una plaza en el autobus "+idTrip;
        }
        return "El autobus esta lleno";
    }
    public String recount(Integer idTrip){
        int plazas=repo.findById(idTrip).get().getPassenger().size();
        return "El autobus "+idTrip+" tiene "+plazas+" plazas ocupadas";
    }
    public ViajeDTO updateStatus(Integer idTrip,String status){
        ViajeDTO dto=repo.findById(idTrip).get().setToDTO();
        dto.setStatus(status);
        return dto;
    }
    public String getStatus(Integer idTrip){
        return "El autobus "+idTrip+" se encuentra: "+repo.findById(idTrip).get().getStatus();
    }


    public List<ViajeDTO> findAll(){
        List<ViajeDTO> list=new ArrayList<>();
        repo.findAll().forEach(viaje -> list.add(viaje.setToDTO()));
        return list;
    }

    public ViajeDTO findById(Integer id){
      return   repo.findById(id).get().setToDTO();
    }

    public ViajeDTO save(Viaje viaje){
        repo.save(viaje);
        return viaje.setToDTO();
    }

    public String delete(Integer id){
        repo.deleteById(id);
        return "Se ha borrado el viaje con id: "+id;
    }
}
