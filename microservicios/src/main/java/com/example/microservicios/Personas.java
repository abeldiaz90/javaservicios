package com.example.microservicios;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Personas {
    @RequestMapping("/greeting")
    public String greeting() {
        return "Hola Abel";
    }
}
