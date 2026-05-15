package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/map")
public class DemoController {

    @GetMapping("/demo")
    public String printDemo(){
        return "Hello World!!";
    }

}
