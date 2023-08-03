package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.Cliente;

public interface ClienteRepocitory extends CrudRepository<Cliente,Long>  {
    
}
