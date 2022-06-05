package com.kuebiko.hello.repo;

import com.kuebiko.hello.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface DictionaryRepo extends JpaRepository<DictionaryEntity,Integer> {


    @Query(value = "SELECT value FROM dictionary_entity where key = ?1", nativeQuery = true)
    public String findByKey(String key);


}
