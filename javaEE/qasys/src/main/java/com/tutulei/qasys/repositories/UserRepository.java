package com.tutulei.qasys.repositories;

import com.tutulei.qasys.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    List<UserEntity> findByUserSchool(String school);
    UserEntity findByUserSchoolAndUserNumAndUserPwd(String school, String number, String pwd);
    UserEntity findByUserNum(String number);
}
