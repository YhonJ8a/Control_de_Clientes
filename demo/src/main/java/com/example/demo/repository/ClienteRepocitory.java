package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.repository.entities.Cliente;
import com.example.demo.repository.entities.Region;

public interface ClienteRepocitory extends CrudRepository<Cliente,Long>  {
     
     @Query("from Region")
     public List<Region> findAllRegiones();
}
