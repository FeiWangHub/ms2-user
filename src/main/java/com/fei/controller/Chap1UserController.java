package com.fei.controller;

import com.fei.dao.UserDao;
import com.fei.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class Chap1UserController {

    @Resource
    UserDao userDao;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public User getUserById(@RequestParam(value = "username") String username,
                            @RequestParam(value = "password") String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userDao.addUser(user);
        return user;
    }
}
