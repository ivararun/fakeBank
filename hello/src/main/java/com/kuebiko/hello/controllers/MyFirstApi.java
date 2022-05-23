package com.kuebiko.hello.controllers;

import com.kuebiko.hello.service.MyFirstService;
import com.kuebiko.hello.service.MyFirstServiceIf;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/abc")
public class MyFirstApi {

    MyFirstServiceIf myFirstServiceIf = new MyFirstService();

    @GetMapping
    @RequestMapping("/sum")
    public int sum(@RequestParam int a, @RequestParam int b){
        int finalValue = myFirstServiceIf.sum(a,b);
        return finalValue;
    }

    @GetMapping
    @RequestMapping("/difference")
    public int difference(@RequestParam int a, @RequestParam int b){
        return myFirstServiceIf.difference(a,b);
    }

    @GetMapping
    @RequestMapping("/multiply")
    public int multiply(@RequestParam int a, @RequestParam int b){
        return myFirstServiceIf.multiply(a,b);
    }

    @GetMapping
    @RequestMapping("/divide")
    public int divide(@RequestParam int a, @RequestParam int b){
        return myFirstServiceIf.divide(a,b);
    }


}
