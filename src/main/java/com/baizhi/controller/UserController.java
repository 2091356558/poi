package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService service;
    @ResponseBody
    @RequestMapping("selectUserAll")
    public Map<String,Object> selectUserAll(Integer page,Integer rows){
        System.out.println(page  + " " + rows);
        Map<String, Object> map = service.selectAllUser(page, rows);
        System.out.println(map.keySet());
        return map;
    }
    @ResponseBody
    @RequestMapping("edit")
    public void edit(String oper, User user){
        if("add".equals(oper)){
            user.setId(UUID.randomUUID().toString());
            System.out.println(user+"----------");
            service.addUser(user);
        }else if("del".equals(oper)){
            System.out.println(user+"++++++++++");
            service.deleteUser(user);
        }else{
            System.out.println(user+"{{{{{{{{{{{{{{");
            service.updateUser(user);
        }
    }
}