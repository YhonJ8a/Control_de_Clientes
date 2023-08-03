package com.example.demo.repository.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "facturas")
public class Factura {
     
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     private String descripcion;
     private String obcerbacion;
     @Column(name = "create_at")
     @Temporal(TemporalType.DATE)
     private Date  createAt;
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
     @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
     @JoinColumn(name = "factura_id")
     private List<ItemFactura> items;

     @JsonIgnoreProperties(value = {"facturas","hibernateLazyInitializer", "handler"}, allowSetters = true)
     @ManyToOne(fetch = FetchType.LAZY)
     private Cliente cliente;

     public Factura(){
          items = new ArrayList<>();
     }

     public Long getId() {
          return id;
     }

     public void setId(Long id) {
          this.id = id;
     }

     public String getDescripcion() {
          return descripcion;
     }

     public void setDescripcion(String descripcion) {
          this.descripcion = descripcion;
     }

     public String getObcerbacion() {
          return obcerbacion;
     }

     public void setObcerbacion(String obcerbacion) {
          this.obcerbacion = obcerbacion;
     }

     public Date getCreateAt() {
          return createAt;
     }

     public void setCreateAt(Date createAt) {
          this.createAt = createAt;
     }

     public List<ItemFactura> getItems() {
          return items;
     }

     public void setItems(List<ItemFactura> items) {
          this.items = items;
     }

     public Cliente getCliente() {
          return cliente;
     }

     public void setCliente(Cliente cliente) {
          this.cliente = cliente;
     }

     public Double getTotal(){
          Double total = 0.00;
          for(ItemFactura items : items){
               total += items.getImporte();
          }
          return total;
     }
}