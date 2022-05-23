package com.kuebiko.hello.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dictionary")
public class Dictionary {

    Map<String, String> map = new HashMap<>();

    private void populate(){
        map.put("Balen", "Mayor of Ktm");
        map.put("UCL", "Liverpool");


    }

    @GetMapping
    @RequestMapping("/search")
    public String search(@RequestParam String searchQuery){

        map.put("apple", "A fruit");
        return map.get(searchQuery);
    }
}
