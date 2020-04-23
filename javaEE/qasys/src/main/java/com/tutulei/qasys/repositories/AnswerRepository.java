package com.tutulei.qasys.repositories;

import com.tutulei.qasys.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Integer> {
    List<AnswerEntity> findByAnswerId(int id);
}
