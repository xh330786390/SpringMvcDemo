package com.tengxh.service.impl;

import com.mysteel.cache.redis.AbstractRedisCacheImpl;
import com.tengxh.common.redis.RedisHelper;
import com.tengxh.dao.DataInfoDao;
import com.tengxh.entity.DataInfo;
import com.tengxh.service.DataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisCluster;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataInfoServiceImpl implements DataInfoService {
    @Autowired
    public DataInfoDao dataInfoDao;

    @Autowired
    private RedisHelper redisHelper;

    @Autowired
    private AbstractRedisCacheImpl abstractRedisCache;


//    public List<DataInfo> selectInfo() {
//        List<DataInfo> arrayList = dataInfoDao.selectInfo();
//        return arrayList;
//    }

    public List<DataInfo> selectInfo() {
        abstractRedisCache.set("key_cluster", "keyvlaue");
        redisHelper.set("key_single", "keyvlaue");
        return dataInfoDao.selectInfo();
    }
}
