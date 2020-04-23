package com.tutulei.qasys.formbean;

import java.sql.Date;

public class Posts {
    private int Id;
    private String postsTitle;
    private String postsMsg;
    private String postsCreator;
    private Date postsCtime;
    private String postsBestanswer;
    private String postsClass;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getPostsTitle() {
        return postsTitle;
    }

    public void setPostsTitle(String postsTitle) {
        this.postsTitle = postsTitle;
    }

    public String getPostsMsg() {
        return postsMsg;
    }

    public void setPostsMsg(String postsMsg) {
        this.postsMsg = postsMsg;
    }

    public String getPostsCreator() {
        return postsCreator;
    }

    public void setPostsCreator(String postsCreator) {
        this.postsCreator = postsCreator;
    }

    public Date getPostsCtime() {
        return postsCtime;
    }

    public void setPostsCtime(Date postsCtime) {
        this.postsCtime = postsCtime;
    }

    public String getPostsBestanswer() {
        return postsBestanswer;
    }

    public void setPostsBestanswer(String postsBestanswer) {
        this.postsBestanswer = postsBestanswer;
    }

    public String getPostsClass() {
        return postsClass;
    }

    public void setPostsClass(String postsClass) {
        this.postsClass = postsClass;
    }
}
