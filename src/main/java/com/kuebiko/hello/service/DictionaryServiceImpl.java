package com.kuebiko.hello.service;

import java.util.HashMap;
import java.util.Map;

public class DictionaryServiceImpl implements DictionaryService{

    private Map<String, String> map = new HashMap<>();

    @Override
    public String search(String searchQuery) {
        String value = map.get(searchQuery);
        return value;
    }

    @Override
    public String add(String key, String value) {
        return map.put(key, value);
    }
}
