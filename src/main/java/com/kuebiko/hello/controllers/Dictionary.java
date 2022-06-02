package com.kuebiko.hello.controllers;

import com.kuebiko.hello.dao.DictionaryDao;
import com.kuebiko.hello.entity.DictionaryEntity;
import com.kuebiko.hello.models.DictionaryModel;
import com.kuebiko.hello.service.DictionaryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dictionary")
public class Dictionary {

    @Autowired
    DictionaryDao dictionarydao;

    @PostMapping
    @RequestMapping("/add")
    public DictionaryEntity add(@RequestBody DictionaryModel model){
        return dictionarydao.save(model.getKey(), model.getValue());

    }


    @GetMapping
    @RequestMapping("/search")
    public String search(@RequestParam String x){
        DictionaryEntity result = dictionarydao.get(x);

        if(result == null){
            return "Definition not found!!";
        }else {
            return result.getDefinition();
        }
    }
}
