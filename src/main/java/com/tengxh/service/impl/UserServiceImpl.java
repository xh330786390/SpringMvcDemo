package com.tengxh.service.impl;

import com.tengxh.dao.UserDao;
import com.tengxh.entity.User;
import com.tengxh.service.DataInfoService;
import com.tengxh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userInfoService")
public class UserServiceImpl implements UserService {
    @Autowired
    public UserDao userDao;

    @Override
    public List<User> selectUser() {
        return userDao.selectUser();
    }

    @Override
    public Integer addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User getUserById(int Id) {
        return userDao.getUserById(Id);
    }

    @Override
    public Integer deleteUser(int Id) {
        return userDao.deleteUser(Id);
    }
}
