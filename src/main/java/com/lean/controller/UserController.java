package com.lean.controller;

import com.lean.domain.User;
import com.lean.exception.ErrorEnum;
import com.lean.service.UserService;
import com.lean.util.ResultObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by llw on 2017/10/10.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @PostMapping("addUser")
    public ResultObject addUser(@RequestBody User user) {
        logger.info("Receive User by name:{}", user.getName());
        if (StringUtils.isBlank(user.getName()) || StringUtils.isBlank(user.getPassword())) {
            return new ResultObject(ErrorEnum.PARAMETERS_ERROR);
        }
        userService.addUser(user);
        return new ResultObject();
    }

    @GetMapping("queryUser/{name}")
    public ResultObject queryUser(@PathVariable String name) {
        logger.info("query user by name:{}", name);
        User user = new User();
        user.setName(name);
        final User newUser = userService.queryUser(user);
        return new ResultObject(newUser);
    }

}
