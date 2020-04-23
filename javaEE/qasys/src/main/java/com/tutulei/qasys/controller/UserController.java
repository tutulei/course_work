package com.tutulei.qasys.controller;

import com.tutulei.qasys.entity.UserEntity;
import com.tutulei.qasys.view.NewUser;
import com.tutulei.qasys.formbean.User;
import com.tutulei.qasys.repositories.UserRepository;
import com.tutulei.qasys.view.Login1View;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private final UserRepository repository;
    //spring会自动依赖注入↓
    UserController(UserRepository repository){
        this.repository = repository;
    }

//用户登录post
    @PostMapping("/login1")
    User Login1(@RequestBody Login1View loginmsg) {
        User user = new User();
        UserEntity userentity = repository.findByUserSchoolAndUserNumAndUserPwd(
                loginmsg.getSchool(),
                loginmsg.getNumber(),
                loginmsg.getPwd()
        );
        if(userentity!=null){
            BeanUtils.copyProperties(userentity, user);
            return user;
        }
        return null;
    }
//用户注册post
    @PostMapping("/register")
    User Register(@RequestBody NewUser newUser){
        UserEntity entity = new UserEntity();
        UserEntity u = repository.findByUserNum(newUser.getUserNum());
        if(u == null){
            BeanUtils.copyProperties(newUser, entity);
            entity.setUserPwd("123456");
            entity.setUserCharacter("student");
            UserEntity userEntity = repository.save(entity);
            User user = new User();
            BeanUtils.copyProperties(userEntity, user);
            return user;
        }
        return null;

    }
}
