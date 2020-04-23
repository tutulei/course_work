package com.tutulei.qasys.controller;

import com.tutulei.qasys.entity.AnswerEntity;
import com.tutulei.qasys.formbean.Answer;
import com.tutulei.qasys.view.NewAnswer;
import com.tutulei.qasys.repositories.AnswerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnswerController {
    private final AnswerRepository repository;
    //spring会自动依赖注入↓
    AnswerController(AnswerRepository repository){
        this.repository = repository;
    }

    //回复帖子post
    @PostMapping("/user/answer/new")
    Answer NewAnswer(@RequestBody NewAnswer newAnswer){
        AnswerEntity entity = new AnswerEntity();
        BeanUtils.copyProperties(newAnswer, entity);
        AnswerEntity postsEntity = repository.save(entity);
        Answer answer = new Answer();
        BeanUtils.copyProperties(postsEntity, answer);
        return answer;
    }
}
