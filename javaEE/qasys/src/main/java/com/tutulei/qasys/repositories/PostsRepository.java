package com.tutulei.qasys.repositories;

import com.tutulei.qasys.entity.PostsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostsRepository extends JpaRepository<PostsEntity, Integer> {
    PostsEntity findByPostsId(int id);
    List<PostsEntity> findByPostsClass(int id);

}