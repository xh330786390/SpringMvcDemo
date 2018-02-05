package com.tengxh.entity;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = -7898194272883238670L;

    public static final String OBJECT_KEY = "USER";


    public User() {
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     *用户Id
     * */
    private Integer id;

    /**
     *用户名称
     * */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return OBJECT_KEY + "_" + getId();
    }
}