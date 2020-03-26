package cn.edu.zucc.pb.ormapping.controller;


import cn.edu.zucc.pb.ormapping.entity.DepartmentEntity;
import cn.edu.zucc.pb.ormapping.entity.UserEntity;
import cn.edu.zucc.pb.ormapping.form.DepartmentForm;
import cn.edu.zucc.pb.ormapping.form.ListUsersFrom;
import cn.edu.zucc.pb.ormapping.form.RegisterFrom;
import cn.edu.zucc.pb.ormapping.service.DepartmentService;
import cn.edu.zucc.pb.ormapping.service.UserService;
import cn.edu.zucc.pb.ormapping.view.Department;
import cn.edu.zucc.pb.ormapping.view.ListUsersResult;
import cn.edu.zucc.pb.ormapping.view.LoginResult;
import cn.edu.zucc.pb.ormapping.view.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class DepartmentController {
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
//        List<Department> list= departmentService.list();
        return null;
    }
    @GetMapping("/list/user")
    @ResponseBody
    public List<User> listUser(){
        departmentService.add("123","保安部");//默认部门
        userService.findById("9527");
        departmentService.register("123","9527");//默认部门下的默认张三
//        List<User> list = departmentService.listUser("123");
        return null;
    }


    ////////////////////////////////////////////////////////////////////////
    @PostMapping("/add")
    @ResponseBody
    public LoginResult add(@RequestBody DepartmentForm departmentForm){
        boolean bLogin = departmentService.add(departmentForm.getId(),departmentForm.getName());
        return createLoginResult(bLogin);
    }
    @PostMapping("/delete")
    @ResponseBody
    public LoginResult delete(@RequestBody  DepartmentForm departmentForm){
        boolean bLogin = departmentService.delete(departmentForm.getId());
        return createLoginResult(bLogin);
    }
    @PostMapping("/register")
    @ResponseBody
    public LoginResult register(@RequestBody RegisterFrom registerFrom){
        boolean bLogin = departmentService.register(registerFrom.getDepartmentid(),registerFrom.getUserid());
        return createLoginResult(bLogin);
    }
    @PostMapping("/listAllDepartment")
    @ResponseBody
    public List<DepartmentEntity> listAll(){
        List<DepartmentEntity> list = departmentService.list();
        return list;
    }
    @PostMapping("/listUsers")
    @ResponseBody
    public List<ListUsersResult> listUsers(@RequestBody ListUsersFrom listUsersFrom){
        List<UserEntity> list = departmentService.listUser(listUsersFrom.getDepartmentId());
        List<ListUsersResult> newList = new ArrayList<ListUsersResult>();
        for(UserEntity l:list){
            ListUsersResult listUsersResult = new ListUsersResult();
            listUsersResult.setUsername(l.getName());
            listUsersResult.setUserid(l.getUserid());
            listUsersResult.setDepartmentid(l.getDpid());
            newList.add(listUsersResult);
        }
        return newList;
    }

    private LoginResult createLoginResult(boolean bLogin) {
        LoginResult ret = new LoginResult();
        if(bLogin){
            ret.setLogin(true);
            ret.setToken(UUID.randomUUID().toString().replaceAll("-", ""));
        } else {
            ret.setLogin(false);
            ret.setToken("");
        }
        return ret;
    }

}
