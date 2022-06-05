package com.kuebiko.hello.repo;

import com.kuebiko.hello.entity.LogInEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepo extends JpaRepository<LogInEntity, Integer> {




}
