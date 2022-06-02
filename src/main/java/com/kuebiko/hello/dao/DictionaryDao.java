package com.kuebiko.hello.dao;

import com.kuebiko.hello.entity.DictionaryEntity;
import com.kuebiko.hello.repo.DictionaryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.text.html.parser.Entity;

@Component
public class DictionaryDao {

    @Autowired
    DictionaryRepo dictionaryRepo;

    public DictionaryEntity save(String word, String definition)
    {
        DictionaryEntity de = new DictionaryEntity();
        long id = System.currentTimeMillis();
        de.setId(id);
        de.setWord(word);
        de.setDefinition(definition);
        DictionaryEntity saved = dictionaryRepo.save(de);
        return saved;
    }

    public DictionaryEntity get(String key){
        return dictionaryRepo.findByKey(key);
    }
}
