package com.tutulei.qasys.formbean;

import java.sql.Date;

public class Answer {
    private int answerId;
    private String answerContent;
    private String answerCreator;
    private Date answerCtime;
    private String answerPosts;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswerContent() {
        return answerContent;
    }

    public void setAnswerContent(String answerContent) {
        this.answerContent = answerContent;
    }

    public String getAnswerCreator() {
        return answerCreator;
    }

    public void setAnswerCreator(String answerCreator) {
        this.answerCreator = answerCreator;
    }

    public Date getAnswerCtime() {
        return answerCtime;
    }

    public void setAnswerCtime(Date answerCtime) {
        this.answerCtime = answerCtime;
    }

    public String getAnswerPosts() {
        return answerPosts;
    }

    public void setAnswerPosts(String answerPosts) {
        this.answerPosts = answerPosts;
    }
}
