package com.kuebiko.hello.service;

import com.kuebiko.hello.dao.DaoImp;
import com.kuebiko.hello.dao.DictionaryDaoIF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class DictionaryServiceImpl implements DictionaryService{

    @Autowired
    DictionaryDaoIF daoImp;
    @Override
    public String search(String searchQuery) {
        return daoImp.retrieve(searchQuery);
    }

    @Override
    public String add(String key, String value) {
        return daoImp.save(key,value);
    }
}
