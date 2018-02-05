package com.tengxh.component.ealsticsearch.impl;

import com.tengxh.component.ealsticsearch.CustomRepository;
import com.tengxh.entity.ArticleInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;


/**
 * Demo class
 *
 * @author keriezhang
 * @date 2016/10/31
 */
@Service("articleRepositoryImpl")
public class ArticleRepositoryImpl implements CustomRepository {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 创建索引
     *
     * @return
     */
    @Override
    public boolean createIndex(String indexName) {
        elasticsearchTemplate.createIndex(indexName);
        elasticsearchTemplate.putMapping(ArticleInfo.class);
        return true;
    }

    public void setElasticsearchTemplate(ElasticsearchTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }


    // <editor-fold desc="折叠">
    /**
     *
     */
    private void s1() {


    }

    /**
     *
     */
    private void s2() {

    }
    // </editor-fold>

    /**
     * 判断指标是否存在
     *
     * @return
     */
    @Override
    public boolean isIndexExists(String indexName) {
        return elasticsearchTemplate.indexExists(indexName);
    }
}
