package com.tutulei.qasys.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "posts", schema = "QAsys", catalog = "")
public class PostsEntity {
    private int postsId;
    private String postsTitle;
    private String postsMsg;
    private byte postsHaspic;
    private String postsCreator;
    private Date postsCtime;
    private String postsBestanswer;
    private String postsClass;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "posts_id")
    public int getPostsId() {
        return postsId;
    }

    public void setPostsId(int postsId) {
        this.postsId = postsId;
    }

    @Basic
    @Column(name = "posts_title")
    public String getPostsTitle() {
        return postsTitle;
    }

    public void setPostsTitle(String postsTitle) {
        this.postsTitle = postsTitle;
    }

    @Basic
    @Column(name = "posts_msg")
    public String getPostsMsg() {
        return postsMsg;
    }

    public void setPostsMsg(String postsMsg) {
        this.postsMsg = postsMsg;
    }

    @Basic
    @Column(name = "posts_haspic")
    public byte getPostsHaspic() {
        return postsHaspic;
    }

    public void setPostsHaspic(byte postsHaspic) {
        this.postsHaspic = postsHaspic;
    }

    @Basic
    @Column(name = "posts_creator")
    public String getPostsCreator() {
        return postsCreator;
    }

    public void setPostsCreator(String postsCreator) {
        this.postsCreator = postsCreator;
    }

    @Basic
    @CreationTimestamp
    @Column(name = "posts_ctime")
    public Date getPostsCtime() {
        return postsCtime;
    }

    public void setPostsCtime(Date postsCtime) {
        this.postsCtime = postsCtime;
    }

    @Basic
    @Column(name = "posts_bestanswer")
    public String getPostsBestanswer() {
        return postsBestanswer;
    }

    public void setPostsBestanswer(String postsBestanswer) {
        this.postsBestanswer = postsBestanswer;
    }

    @Basic
    @Column(name = "posts_class")
    public String getPostsClass() {
        return postsClass;
    }

    public void setPostsClass(String postsClass) {
        this.postsClass = postsClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostsEntity that = (PostsEntity) o;
        return postsId == that.postsId &&
                postsHaspic == that.postsHaspic &&
                Objects.equals(postsTitle, that.postsTitle) &&
                Objects.equals(postsMsg, that.postsMsg) &&
                Objects.equals(postsCreator, that.postsCreator) &&
                Objects.equals(postsCtime, that.postsCtime) &&
                Objects.equals(postsBestanswer, that.postsBestanswer) &&
                Objects.equals(postsClass, that.postsClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postsId, postsTitle, postsMsg, postsHaspic, postsCreator, postsCtime, postsBestanswer, postsClass);
    }
}
