package cn.edu.zucc.pb.rest.view;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-11 17:50
 */
public class User {
    private String name;
    private String userid;
    private String password;
    private  String depid;

    public String getDepid() {
        return depid;
    }

    public void setDepid(String depid) {
        this.depid = depid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
