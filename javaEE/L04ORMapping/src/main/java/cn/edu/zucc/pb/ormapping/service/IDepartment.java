package cn.edu.zucc.pb.ormapping.service;


import cn.edu.zucc.pb.ormapping.entity.DepartmentEntity;
import cn.edu.zucc.pb.ormapping.entity.UserEntity;
import cn.edu.zucc.pb.ormapping.view.Department;
import cn.edu.zucc.pb.ormapping.view.User;

import java.util.List;

public interface IDepartment {
    boolean add(String ID ,String Name);
    boolean delete(String ID);
    boolean register(String depID, String uID);//将用户加入部门
    List<DepartmentEntity> list();
    List<UserEntity> listUser(String depID);
}
