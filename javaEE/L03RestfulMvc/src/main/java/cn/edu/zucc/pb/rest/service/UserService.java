package cn.edu.zucc.pb.rest.service;

import cn.edu.zucc.pb.rest.view.Department;
import cn.edu.zucc.pb.rest.view.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-03-11 17:53
 */
@Service
public class UserService {
    public static List<User> users=new ArrayList<User>();;
    public User findById(String id) {
        //这里是简单示例，所以直接创建一个这样的user返回,不执行具体的查询
        User ret = new User();
        ret.setName("张三");
        ret.setUserid(id);
        ret.setPassword("123456");
        for(int i =0 ;i< UserService.users.size();i++){
            if (id.equals(UserService.users.get(i).getUserid())) {
               return ret;
            }
        }
        UserService.users.add(ret);
        return ret;
    }
}
