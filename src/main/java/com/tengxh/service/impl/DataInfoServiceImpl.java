package com.tengxh.service.impl;

import com.mysteel.cache.redis.AbstractRedisCacheImpl;
import com.tengxh.dao.DataInfoDao;
import com.tengxh.entity.DataInfo;
import com.tengxh.service.DataInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataInfoServiceImpl implements DataInfoService {
    @Autowired
    public DataInfoDao dataInfoDao;

    @Autowired
    private AbstractRedisCacheImpl abstractRedisCache;

//    public List<DataInfo> selectInfo() {
//        List<DataInfo> arrayList = dataInfoDao.selectInfo();
//        return arrayList;
//    }

    public List<DataInfo> selectInfo() {

//        abstractRedisCache.set("key_cluster", "keyvlaue");
        return dataInfoDao.selectInfo();
    }
}
