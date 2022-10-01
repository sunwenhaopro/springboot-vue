package com.cxxj.controller;
import com.cxxj.bean.User;
import com.cxxj.response.Result;
import com.cxxj.service2.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;


@Controller
public class SignupController {

    @Autowired
    Userservice userService;

    //登录
    @CrossOrigin
    @PostMapping(value = "/login/signup")
    @ResponseBody
    public Result signup(@RequestBody User requestUser) {
        String username = requestUser.getUsername();
        username = HtmlUtils.htmlEscape(username);
         int res=userService.isExist(username);
         if(res==0){
             return new Result(400);
         }else{
             userService.save(requestUser);
             return new Result(200);
         }
    }

}

//注册

