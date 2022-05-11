/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appEscuela.serviceImpl;

import com.example.appEscuela.dao.EscuelaDao;
import com.example.appEscuela.model.Escuela;
import com.example.appEscuela.service.EscuelaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Victor Rosales
 */
@Service 
public class EscuelaServiceImpl implements EscuelaService {
    @Autowired
    private EscuelaDao escuelaDao; 
    
    @Override
    public int create(Escuela esc) {
        return escuelaDao.create(esc);
    }

    @Override
    public int update(Escuela esc) {
        return escuelaDao.update(esc);
    }

    @Override
    public int delete(int id) {
        return escuelaDao.delete(id);
    }

    @Override
    public Escuela read(int id) {
        return escuelaDao.read(id);
    }

    @Override
    public List<Escuela> readAll() {
        return escuelaDao.readAll();
    }
    
}
