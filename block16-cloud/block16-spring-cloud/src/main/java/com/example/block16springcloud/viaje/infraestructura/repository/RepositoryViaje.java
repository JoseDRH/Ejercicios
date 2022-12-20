package com.example.block16springcloud.viaje.infraestructura.repository;

import com.example.block16springcloud.viaje.domain.entity.Viaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryViaje extends CrudRepository<Viaje,Integer> {
}
