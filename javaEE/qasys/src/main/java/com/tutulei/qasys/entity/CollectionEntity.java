package com.tutulei.qasys.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "collection", schema = "QAsys", catalog = "")
public class CollectionEntity {
    private int collectionId;
    private String collectionBelonger;
    private String collectionPosts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "collection_id")
    public int getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(int collectionId) {
        this.collectionId = collectionId;
    }

    @Basic
    @Column(name = "collection_belonger")
    public String getCollectionBelonger() {
        return collectionBelonger;
    }

    public void setCollectionBelonger(String collectionBelonger) {
        this.collectionBelonger = collectionBelonger;
    }

    @Basic
    @Column(name = "collection_posts")
    public String getCollectionPosts() {
        return collectionPosts;
    }

    public void setCollectionPosts(String collectionPosts) {
        this.collectionPosts = collectionPosts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionEntity that = (CollectionEntity) o;
        return collectionId == that.collectionId &&
                Objects.equals(collectionBelonger, that.collectionBelonger) &&
                Objects.equals(collectionPosts, that.collectionPosts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(collectionId, collectionBelonger, collectionPosts);
    }
}
