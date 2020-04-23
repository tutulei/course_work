package com.tutulei.qasys.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "likes", schema = "QAsys", catalog = "")
public class LikesEntity {
    private int likesId;
    private String likesBelonger;
    private byte likesIsposts;
    private int likesLike;
    private int likesDislike;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "likes_id")
    public int getLikesId() {
        return likesId;
    }

    public void setLikesId(int likesId) {
        this.likesId = likesId;
    }

    @Basic
    @Column(name = "likes_belonger")
    public String getLikesBelonger() {
        return likesBelonger;
    }

    public void setLikesBelonger(String likesBelonger) {
        this.likesBelonger = likesBelonger;
    }

    @Basic
    @Column(name = "likes_isposts")
    public byte getLikesIsposts() {
        return likesIsposts;
    }

    public void setLikesIsposts(byte likesIsposts) {
        this.likesIsposts = likesIsposts;
    }

    @Basic
    @Column(name = "likes_like")
    public int getLikesLike() {
        return likesLike;
    }

    public void setLikesLike(int likesLike) {
        this.likesLike = likesLike;
    }

    @Basic
    @Column(name = "likes_dislike")
    public int getLikesDislike() {
        return likesDislike;
    }

    public void setLikesDislike(int likesDislike) {
        this.likesDislike = likesDislike;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LikesEntity that = (LikesEntity) o;
        return likesId == that.likesId &&
                likesIsposts == that.likesIsposts &&
                likesLike == that.likesLike &&
                likesDislike == that.likesDislike &&
                Objects.equals(likesBelonger, that.likesBelonger);
    }

    @Override
    public int hashCode() {
        return Objects.hash(likesId, likesBelonger, likesIsposts, likesLike, likesDislike);
    }
}
