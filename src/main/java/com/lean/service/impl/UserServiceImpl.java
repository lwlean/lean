package com.lean.service.impl;


import com.lean.domain.User;
import com.lean.mapper.UserMapper;
import com.lean.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by llw on 2017/9/29.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public User queryUser(User user) {
        return userMapper.queryUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int deleteUser(User user) {
        return userMapper.deleteUser(user);
    }

    @Override
    public List<User> queryUser() {
        return userMapper.getAllUser();
    }
}
