package com.kuebiko.hello.service;

import com.kuebiko.hello.dao.DictionaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
   DictionaryDao dictionaryDao;

    @Override
    public String search(String searchQuery) {
        return dictionaryDao.get(searchQuery);
    }

    @Override
    public String add(String key, String value){
        return null;
    }
}
