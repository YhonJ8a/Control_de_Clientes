package com.example.demo.countroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    
    @GetMapping("/hola/{nombre}")
    public String saludo(@PathVariable String nombre){
        return "Saludo , como estas "+nombre;
    }

    @GetMapping("/saludo")
    public String saludo2(){
        return "Saludo , como estas?";
    }
}
