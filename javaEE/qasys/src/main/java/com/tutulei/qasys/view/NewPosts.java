package com.tutulei.qasys.view;

import java.sql.Date;

public class NewPosts {
    private String postsTitle;
    private String postsMsg;
    private byte postsHaspic;
    private String postsCreator;
    private String postsClass;

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

    public byte getPostsHaspic() {
        return postsHaspic;
    }

    public void setPostsHaspic(byte postsHaspic) {
        this.postsHaspic = postsHaspic;
    }

    public String getPostsCreator() {
        return postsCreator;
    }

    public void setPostsCreator(String postsCreator) {
        this.postsCreator = postsCreator;
    }

    public String getPostsClass() {
        return postsClass;
    }

    public void setPostsClass(String postsClass) {
        this.postsClass = postsClass;
    }
}
