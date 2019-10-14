package com.baizhi.service;

import com.baizhi.entity.User;

import java.util.Map;

public interface UserService {
    //分页查询所有员工
    public Map<String,Object> selectAllUser(Integer page, Integer rows);
    //修改员工信息
    public void updateUser(User user);
    //增加员工
    public void addUser(User user);
    //删除员工
    public void deleteUser(User user);
}
