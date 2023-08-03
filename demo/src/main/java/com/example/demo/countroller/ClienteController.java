package com.example.demo.countroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.entities.Cliente;
import com.example.demo.services.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> index(){
        return clienteService.findAll();
    }

    @GetMapping("/cliente/{id}")
    public Cliente show(@PathVariable long id){
        return clienteService.findById(id);
    }

    @PostMapping("/cliente")
    public ResponseEntity <?> create(@Valid @RequestBody Cliente cliente, BindingResult result){
        Cliente clienteNew = null;

        Map<String, Object> response = new HashMap<>();
        
        if(result.hasErrors()){
            List<String> errors = result.getFieldErrors()
                        .stream()
                        .map(err -> "El campó " + err.getField() + " " + err.getDefaultMessage())
                        .collect(Collectors.toList());
            response.put("erros", errors);
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);
        }

        try {
            clienteNew = clienteService.save(cliente);
        }catch  (DataAccessException e) { 
            response.put("mensaje", "Error al realizar el incert en la base de datos");
            response.put("error", e.getMessage().concat(" <:> ").concat(e.getMostSpecificCause().getMessage()));
            return new ResponseEntity<Map<String,Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        response.put("mensaje", "El cliente ha sido creado con exito ");        
        response.put("cliente", clienteNew);

        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.CREATED);
    }
}
