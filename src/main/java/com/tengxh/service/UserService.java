package com.tengxh.service;

import com.tengxh.entity.User;

import java.util.List;

public interface UserService {
    /**
     * 查找用户列表
     */
    List<User> selectUser();

    /**
     * 通过Id获取用户信息
     */
    User getUserById(int Id);

    /**
     * 添加用户
     */
    Integer addUser(User dataSource);

    /**
     * 修改用户
     */
    Integer updateUser(User dataSource);

    /**
     * 删除用户
     */
    Integer deleteUser(int Id);
}
