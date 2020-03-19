package cn.edu.zucc.pb.rest.common;

import cn.edu.zucc.pb.rest.view.Department;
import cn.edu.zucc.pb.rest.view.User;

import java.util.List;

public interface IDepartment {
    boolean add(String ID,String Name);
    boolean delete(String ID);
    boolean register(String depID,String uID);//将用户加入部门
    List<Department> list();
    List<User> listUser(String depID);
}
