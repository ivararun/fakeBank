package com.bank.kuebikofakebank.repo;

import com.bank.kuebikofakebank.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepoIF extends JpaRepository<UserEntity,Long> {

}
