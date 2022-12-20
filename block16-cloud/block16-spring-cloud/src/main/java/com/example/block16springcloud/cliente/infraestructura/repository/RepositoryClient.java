package com.example.block16springcloud.cliente.infraestructura.repository;

import com.example.block16springcloud.cliente.domain.entity.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryClient extends CrudRepository<Cliente, Integer> {
}
