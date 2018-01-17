package com.tengxh.component.redis;
import org.springframework.data.redis.core.RedisTemplate;

public interface UserService <T>{
    public void put(T t) ;

    public void delete(T t);

    public T get(T key) ;
}