package com.tutulei.qasys.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "QAsys", catalog = "")
public class UserEntity {
    private int userId;
    private String userName;
    private String userNum;
    private String userPwd;
    private String userCharacter;
    private String userSchool;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "user_num")
    public String getUserNum() {
        return userNum;
    }

    public void setUserNum(String userNum) {
        this.userNum = userNum;
    }

    @Basic
    @Column(name = "user_pwd")
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "user_character")
    public String getUserCharacter() {
        return userCharacter;
    }

    public void setUserCharacter(String userCharacter) {
        this.userCharacter = userCharacter;
    }

    @Basic
    @Column(name = "user_school")
    public String getUserSchool() {
        return userSchool;
    }

    public void setUserSchool(String userSchool) {
        this.userSchool = userSchool;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
                Objects.equals(userName, that.userName) &&
                Objects.equals(userNum, that.userNum) &&
                Objects.equals(userPwd, that.userPwd) &&
                Objects.equals(userCharacter, that.userCharacter) &&
                Objects.equals(userSchool, that.userSchool);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userNum, userPwd, userCharacter, userSchool);
    }
}
