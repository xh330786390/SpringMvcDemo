package com.tengxh.component.ealsticsearch;


/**
 * 自定义Repository接口
 *
 */
public interface OrderEsCommonRepository {
    /**
     * 创建索引
     * @return
     */
    public boolean createOrderIndex();
}
