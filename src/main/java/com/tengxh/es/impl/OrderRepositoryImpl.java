package com.tengxh.es.impl;

import com.tengxh.entity.Order;
import com.tengxh.es.OrderEsCommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderRepositoryImpl implements OrderEsCommonRepository {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    public boolean createOrderIndex() {
        return elasticsearchTemplate.createIndex(Order.class);
    }

    public void setElasticsearchTemplate(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }
}
