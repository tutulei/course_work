package com.tutulei.qasys.controller;

import com.tutulei.qasys.entity.PostsEntity;
import com.tutulei.qasys.repositories.PostsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private final PostsRepository repository;
    //spring会自动依赖注入↓
    HelloController(PostsRepository repository){
        this.repository = repository;
    }

    @GetMapping("/question/{id}")
    PostsEntity one(@PathVariable int id) {
        return repository.findByPostsId(id);


    }
}