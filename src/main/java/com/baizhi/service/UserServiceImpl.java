package com.baizhi.service;

import com.baizhi.entity.User;
import com.baizhi.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public Map<String,Object> selectAllUser(Integer page, Integer rows) {
        if(page == 1){
            page = 0;
        }
        HashMap<String, Object> map = new HashMap<>();
        log.debug("{}",map.keySet());
        List<User> users = userMapper.selectAllUser(page, rows); //展示的数据
        Integer total = userMapper.selectCount();//总条数
        Integer totalPage = total % rows == 0 ? total / rows : total / rows +1;  //页数
        map.put("rows",users);
        map.put("records",total);
        map.put("page",page);
        map.put("total",totalPage);
        return map;
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userMapper.deleteUser(user);
    }
}
