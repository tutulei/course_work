package cn.edu.zucc.pb.ormapping.entity;

public class UserEntity {
    private String userid;
    private String name;
    private String password;
    private String dpid;

    public String getDpid() {
        return dpid;
    }

    public void setDpid(String dpid) {
        this.dpid = dpid;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
