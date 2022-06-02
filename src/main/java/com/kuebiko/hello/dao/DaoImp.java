package com.kuebiko.hello.dao;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class DaoImp implements DictionaryDaoIF{
    private Map<String, String> map = new HashMap<>();

    @Override
    public String save(String key, String value) {
        return map.put(key, value);
    }

    @Override
    public String retrieve(String key) {
        String value = map.get(key);
        return value;
    }
}
