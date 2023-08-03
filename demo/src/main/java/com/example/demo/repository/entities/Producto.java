package com.example.demo.repository.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity()
@Table(name = "productos")
public class Producto {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String nombre;
     private Double precio;
     @Column(name = "create_at")
     private Date createAt;

     @PrePersist
     public void PrePersist(){
          this.createAt = new Date();
     }

     public Long getId() {
          return id;
     }
     public void setId(Long id) {
          this.id = id;
     }
     public String getNombre() {
          return nombre;
     }
     public void setNombre(String nombre) {
          this.nombre = nombre;
     }
     public Double getPrecio() {
          return precio;
     }
     public void setPrecio(Double precio) {
          this.precio = precio;
     }
     public Date getCreateAt() {
          return createAt;
     }
     public void setCreateAt(Date createAt) {
          this.createAt = createAt;
     }

     
}
