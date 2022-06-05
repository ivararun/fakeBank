package com.kuebiko.hello.controllers;

import com.kuebiko.hello.models.DictionaryModel;
import com.kuebiko.hello.service.DictionaryServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dictionary")
public class Dictionary {

    DictionaryServiceImpl dictionaryServiceImpl = new DictionaryServiceImpl();

    @PostMapping
    @RequestMapping("/add")
    public String add(@RequestBody DictionaryModel model){
        return dictionaryServiceImpl.add(model.getKey(), model.getValue());

    }


    @GetMapping
    @RequestMapping("/search")
    public String search(@RequestParam String x){
        String result = dictionaryServiceImpl.search(x);
        return result;
    }
}
