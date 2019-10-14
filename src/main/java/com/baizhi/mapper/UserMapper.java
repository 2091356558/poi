package com.baizhi.mapper;

import com.baizhi.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //分页查询所有员工
    public List<User> selectAllUser(@Param("start") Integer start, @Param("rows") Integer rows);
    //查询员工总人数
    public Integer selectCount();
    //修改员工信息
    public void updateUser(User user);
    //增加员工
    public void addUser(User user);
    //删除员工
    public void deleteUser(User user);
}