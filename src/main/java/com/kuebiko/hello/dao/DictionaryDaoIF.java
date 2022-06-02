package com.kuebiko.hello.dao;

public interface DictionaryDaoIF {
    String save(String key, String value);
    String retrieve(String key);

}
