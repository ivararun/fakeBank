package com.bank.kuebikofakebank.repo;

import com.bank.kuebikofakebank.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepoIF extends JpaRepository<LoginEntity,Long> {

    @Query(value = "select Id from login_entity where username=?1 and password=?2",nativeQuery = true)
        public Long chkLogin(String username,String password);
}
