/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appEscuela.controller;

import com.example.appEscuela.model.Escuela;
import com.example.appEscuela.service.EscuelaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Victor Rosales
 */

@RestController
@RequestMapping("/esc")
public class EscuelaRestController {
    @Autowired
    private EscuelaService escService;
    
    @GetMapping("/all")
    public List<Escuela> getEscuelas() {
        return escService.readAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Escuela> getEscuela(@PathVariable int id) {
        Escuela esc = escService.read(id);
        return ResponseEntity.ok(esc);
    }
    
    @DeleteMapping("/{id}")
    public int deleteEscuela(@PathVariable int id) {        
        return escService.delete(id);
    }
    
    @PostMapping("/add")
    public int addEscuela(@RequestBody Escuela esc) {  
        System.out.println(esc.getNombre());
        return escService.create(esc);
    }
    
    @PutMapping("/edit")
    public int editEscuela(@RequestBody Escuela esc) {  
       Escuela es = new Escuela(esc.getIdescuela(),esc.getNombre());
        System.out.println(esc.getIdescuela()+" , "+esc.getNombre());
        return escService.update(esc);
    }
}
