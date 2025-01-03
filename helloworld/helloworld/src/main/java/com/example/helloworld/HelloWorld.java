package com.example.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {
    @GetMapping("/")
    public String getHello() {
        return "Hello";
    }
    @GetMapping("/name")
    public String getName(){
return "Balu";
    }
}
