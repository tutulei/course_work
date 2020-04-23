package com.tutulei.qasys.controller;

import com.tutulei.qasys.entity.PostsEntity;
import com.tutulei.qasys.view.NewPosts;
import com.tutulei.qasys.formbean.Posts;
import com.tutulei.qasys.repositories.PostsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PostsController {
    private final PostsRepository repository;
    //spring会自动依赖注入↓
    PostsController(PostsRepository repository){
        this.repository = repository;
    }

//帖子列表post
    @PostMapping("/user/posts/list")
    List<Posts> GetPostsList(@RequestBody int classId){
        List<Posts> postslist = new ArrayList<Posts>();
        List<PostsEntity> postsEntities = repository.findByPostsClass(classId);
        for(PostsEntity p:postsEntities){
            Posts posts = new Posts();
            BeanUtils.copyProperties(p, posts);
            postslist.add(posts);
        }
        if(postslist.size()>0){
            return postslist;
        }
        return null;
    }
    //帖子详情post
    @PostMapping("/user/posts/getone")
    Posts GetPosts(@RequestBody int postsId){
        PostsEntity postsEntity = repository.findByPostsId(postsId);
        Posts posts = new Posts();
        if(postsEntity != null){
            BeanUtils.copyProperties(postsEntity, posts);
            return posts;
        }
        return null;
    }
    //帖子发布post
    @PostMapping("/user/posts/new")
    Posts NewPosts(@RequestBody NewPosts newPosts){
        PostsEntity entity = new PostsEntity();
        BeanUtils.copyProperties(newPosts, entity);
        PostsEntity postsEntity = repository.save(entity);
        Posts posts = new Posts();
        BeanUtils.copyProperties(postsEntity, posts);
        return posts;
    }
}
