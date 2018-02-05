package com.tengxh.component.ealsticsearch;

/**
 * 自定义Repository接口
 *
 */
public interface CustomRepository {
    /**
     * 判断索引是否存在
     * @param indexName
     * @return
     */
    boolean isIndexExists(String indexName);

    /**
     * 创建索引
     * @param indexName
     * @return
     */
    boolean createIndex(String indexName);
}