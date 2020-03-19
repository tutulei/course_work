package cn.edu.zucc.pb.rest.service;

import cn.edu.zucc.pb.rest.common.IDepartment;
import cn.edu.zucc.pb.rest.view.Department;
import cn.edu.zucc.pb.rest.view.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class DepartmentService implements IDepartment {
    public static List<Department> departments=new ArrayList<Department>();
    public boolean add(String ID, String Name) {
        for(int i=0; i< DepartmentService.departments.size(); i++) {
            if(ID.equals(DepartmentService.departments.get(i).getDepartmentId())){
                //部门已存在
                return false;
            }
        }
        Department dep=new Department();
        dep.setDepartmentId(ID);
        dep.setDepartmentName(Name);
        DepartmentService.departments.add(dep);
        return true;
    }

    public boolean delete(String ID) {
        for(int i=0; i< DepartmentService.departments.size(); i++) {
            if(ID.equals(DepartmentService.departments.get(i).getDepartmentId())){
                if(DepartmentService.departments.get(i).getUsers().isEmpty()){
                    DepartmentService.departments.remove(i);
                    return true;
                }else {
                    //部门非空
                    return false;
                }
            }
        }
        //无该部门
        return false;
    }

    public boolean register(String depID, String uID) {
        for(int i=0; i< DepartmentService.departments.size(); i++) {
            if(depID.equals(DepartmentService.departments.get(i).getDepartmentId())){
                for (int j = 0 ;j<UserService.users.size();j++){
                    if (uID.equals(UserService.users.get(j).getUserid())&&UserService.users.get(j).getDepid()==null) {
                        UserService.users.get(j).setDepid(depID);
                        List<User> users = DepartmentService.departments.get(i).getUsers();
                        users.add(UserService.users.get(j));
                        DepartmentService.departments.get(i).setUsers(users);
                        return true;
                    }
                }
                //无该用户或者该用户已经有部门了
                break;
            }
        }
        //无该部门
        return false;
    }

    public List<Department> list() {
        return DepartmentService.departments;
    }

    public List<User> listUser(String depID) {
        for(int i=0; i< DepartmentService.departments.size(); i++) {
            if(depID.equals(DepartmentService.departments.get(i).getDepartmentId())){
                return DepartmentService.departments.get(i).getUsers();
            }
        }
        //部门不存在
        return null;
    }
}
