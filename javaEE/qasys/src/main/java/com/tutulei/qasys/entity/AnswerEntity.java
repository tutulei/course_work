package com.tutulei.qasys.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "answer", schema = "QAsys", catalog = "")
public class AnswerEntity {
    private int answerId;
    private String answerContent;
    private String answerCreator;
    private Date answerCtime;
    private String answerPosts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "answer_id")
    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    @Basic
    @Column(name = "answer_content")
    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    @Basic
    @Column(name = "answer_creator")
    public String getAnswerCreator() {
        return answerCreator;
    }

    public void setAnswerCreator(String answerCreator) {
        this.answerCreator = answerCreator;
    }

    @Basic
    @CreationTimestamp
    @Column(name = "answer_ctime")
    public Date getAnswerCtime() {
        return answerCtime;
    }

    public void setAnswerCtime(Date answerCtime) {
        this.answerCtime = answerCtime;
    }

    @Basic
    @Column(name = "answer_posts")
    public String getAnswerPosts() {
        return answerPosts;
    }

    public void setAnswerPosts(String answerPosts) {
        this.answerPosts = answerPosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnswerEntity that = (AnswerEntity) o;
        return answerId == that.answerId &&
                Objects.equals(answerContent, that.answerContent) &&
                Objects.equals(answerCreator, that.answerCreator) &&
                Objects.equals(answerCtime, that.answerCtime) &&
                Objects.equals(answerPosts, that.answerPosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, answerContent, answerCreator, answerCtime, answerPosts);
    }
}
