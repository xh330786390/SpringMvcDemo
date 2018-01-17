package com.tengxh.component.redis.impl;

import com.tengxh.entity.User;
import com.tengxh.component.redis.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserImpl implements UserService<User> {
    @Autowired
    RedisTemplate<String, User> redisTemplate;
    
    public void put(User user) {
        redisTemplate.opsForValue().set(user.getKey(), user);
    }

    public void delete(User user) {
        redisTemplate.delete(user.getKey());
    }

    public User get(User user) {
        return (User) redisTemplate.opsForValue().get(user.getKey());
    }
}