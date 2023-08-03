package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.repository.ClienteRepocitory;
import com.example.demo.repository.entities.Cliente;
import com.example.demo.repository.entities.Region;
import com.example.demo.services.ClienteService;


@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepocitory clienteRepocitory;

    @Override
    @Transactional(readOnly = true) 
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteRepocitory.findAll();
    }

    @Override
    @Transactional(readOnly = true) 
    public Cliente findById(long Id) {
        return clienteRepocitory.findById(Id).orElse(null);
    }

    @Override
    @Transactional(readOnly = false) 
    public Cliente save(Cliente cliente) {
        return clienteRepocitory.save(cliente);
    }

    @Override
    @Transactional(readOnly = false) 
    public void delete(Cliente cliente) {
        clienteRepocitory.delete(cliente);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Region> findAllRegiones(){
        return clienteRepocitory.findAllRegiones();
    }
}
