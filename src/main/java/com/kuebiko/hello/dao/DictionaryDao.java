package com.kuebiko.hello.dao;


import com.kuebiko.hello.repo.DictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DictionaryDao {

    @Autowired
    DictionaryRepo dictionaryRepo;

    public int save(String key,String value){
        return 0;
    }

    public String get(String key){
        return dictionaryRepo.findByKey(key);
    }

}
