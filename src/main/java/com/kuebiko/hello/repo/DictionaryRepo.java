package com.kuebiko.hello.repo;

import com.kuebiko.hello.entity.DictionaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryRepo extends JpaRepository<DictionaryEntity,Long> {
    @Query(value ="select * from dictionary_entity where word = ?1",nativeQuery=true)
    public DictionaryEntity findByKey(String key);
}
