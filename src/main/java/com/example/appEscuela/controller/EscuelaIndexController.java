/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.appEscuela.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Victor Rosales
 */
@Controller
@RequestMapping({"/", "/index"})
public class EscuelaIndexController {

    @GetMapping
    public String index() {
        return "index";
    }
}
