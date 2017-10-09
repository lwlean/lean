package com.lean.mapper;

import com.lean.domain.User;

/**
 * Created by llw on 2017/9/29.
 */
public interface UserMapper {

    void addUser(User user);

    User queryUser(User user);

    int updateUser(User user);

    int deleteUser(User user);

}
