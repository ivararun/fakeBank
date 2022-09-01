package com.practice.sumitdai.repo;


import com.practice.sumitdai.entity.ProfileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<ProfileEntity, Long> {

//    @Query(value = "select * from profile_entity where ssn = ?1 ", nativeQuery = true)
//    public ProfileEntity view(String ssn);

    @Query(value = "select * from profiles where ssn = ?1", nativeQuery = true)
    public ProfileEntity view(String ssn);
}
