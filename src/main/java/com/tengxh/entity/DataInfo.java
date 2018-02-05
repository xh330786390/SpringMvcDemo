package com.tengxh.entity;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author tengxh
 * @date 2018/01/31
 */

public class DataInfo implements Serializable {
    private long id;
    private String dataName;

    public long getId() {
        return id;
    }

    public String getDataName() {
        return dataName;
    }

    public void setDataName(String dataName) {
        this.dataName = dataName;
    }

    public void setId(long id) {
        this.id = id;
    }
}
