package com.corporativoX.cursoSpringBoot.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRestController {

    @GetMapping({"/hello", "/hw", "/hola"})
    public String helloWorld(){
        System.out.println("¡Solicitud ejecutada!");
        return "Hello, World";
    }
}