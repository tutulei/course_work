package cn.edu.zucc.pb.ioc.controller;

import cn.edu.zucc.pb.ioc.service.ILogin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用POST
 * POST url
 * request body : name=admin&password=123456
 *
 * @author pengbin
 * @version 1.0
 * @date 2020-03-21 15:37
 */
public class LoginController{
    //TODO 改造这个参数绑定的方式，请使用类似Spring能够绑定属性的方法
    //比如可以设置private IDoSomething service; 然后可以使用配置来动态设置此service供controller使用
    private ILogin loginService;

    public void setLoginService(Object loginService) {
        this.loginService = (ILogin)loginService;
    }

    public String doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");

        if(loginService.login(userid, password)){
            return "login successful.";
        } else {
            return "login failed.";
        }
    }

}
