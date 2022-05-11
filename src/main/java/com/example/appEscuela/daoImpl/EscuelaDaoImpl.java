/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appEscuela.daoImpl;

import com.example.appEscuela.dao.EscuelaDao;
import com.example.appEscuela.model.Escuela;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Victor Rosales
 */
@Repository

public class EscuelaDaoImpl implements EscuelaDao {
    @Autowired
    private JdbcTemplate jdbcTemplate; 
    
    @Override
    public int create(Escuela esc) {
        String SQL ="INSERT INTO escuela (nombre) VALUES(?)";
        return jdbcTemplate.update(SQL,new Object[]{esc.getNombre()});
  
   }

    @Override
    public int update(Escuela esc) {
       String SQL ="UPDATE escuela SET nombre=? WHERE idescuela=?";                 
        return jdbcTemplate.update(SQL,new Object[]{esc.getNombre() , esc.getIdescuela()});
  
    }

    @Override
    public int delete(int id) {
        String SQL ="DELETE FROM escuela WHERE idescuela=?"; 
        return jdbcTemplate.update(SQL,id);
    }

    @Override
    public Escuela read(int id) {
        String SQL ="SELECT * FROM escuela WHERE idescuela=?";
        try {
            Escuela esc = jdbcTemplate.queryForObject(SQL, BeanPropertyRowMapper.newInstance(Escuela.class),id);
            return esc;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public List<Escuela> readAll() {
        String SQL ="SELECT idescuela, nombre FROM escuela ORDER BY idescuela ASC";        
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Escuela.class));
    }
    
}
