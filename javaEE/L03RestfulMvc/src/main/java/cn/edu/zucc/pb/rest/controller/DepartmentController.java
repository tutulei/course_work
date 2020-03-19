package cn.edu.zucc.pb.rest.controller;

import cn.edu.zucc.pb.rest.common.IDepartment;
import cn.edu.zucc.pb.rest.service.DepartmentService;
import cn.edu.zucc.pb.rest.service.UserService;
import cn.edu.zucc.pb.rest.view.Department;
import cn.edu.zucc.pb.rest.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController  {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserService userService;


    @GetMapping("/add/department/{id}/{name}")
    @ResponseBody
    public boolean addDepartment(@PathVariable("id") String id,@PathVariable("name") String name){
        return departmentService.add(id,name);
    }

    @GetMapping("/list/department")
    @ResponseBody
    public List<Department> listDepartment(){
        departmentService.add("123","保安部");//默认部门
        List<Department> list= departmentService.list();
        return list;
    }
    @GetMapping("/list/user")
    @ResponseBody
    public List<User> listUser(){
        departmentService.add("123","保安部");//默认部门
        userService.findById("9527");
        departmentService.register("123","9527");//默认部门下的默认张三
        List<User> list = departmentService.listUser("123");
        return list;
    }

}
