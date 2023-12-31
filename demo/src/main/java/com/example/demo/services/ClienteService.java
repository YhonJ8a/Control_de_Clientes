package com.example.demo.services;

import java.util.List;

import com.example.demo.repository.entities.Cliente;
import com.example.demo.repository.entities.Region;

public interface ClienteService {
    public List<Cliente> findAll();

    public Cliente findById(long Id);

    public Cliente save(Cliente cliente);

    public void delete(Cliente cliente);
    
    public List<Region> findAllRegiones();
    
}
