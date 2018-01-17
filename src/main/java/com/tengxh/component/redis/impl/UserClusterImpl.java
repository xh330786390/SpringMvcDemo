package com.tengxh.component.redis.impl;

import com.alibaba.fastjson.JSONObject;
import com.mysteel.cache.redis.AbstractRedisCacheImpl;
import com.tengxh.component.redis.UserService;
import com.tengxh.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

@Service("userClusterService")
public class UserClusterImpl implements UserService<User> {
    @Autowired
    private AbstractRedisCacheImpl abstractRedisCache;

    public void put(User user) {
        String json = JSONObject.toJSONString(user);
        abstractRedisCache.set("Cluster_" + user.getKey(), json);
    }

    public void delete(User user) {
    }

    public User get(User user) {
        String json = abstractRedisCache.get("Cluster_" + user.getKey(), "");
        JSONObject jsonObject = JSONObject.parseObject(json);
        String name = jsonObject.getString("name");
        user.setName(name);
        return user;
    }
}