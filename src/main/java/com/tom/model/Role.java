package com.tom.model;

import java.io.Serializable;

public class Role implements Serializable {

    private static final long serialVersionUID = -3197678051582892163L;
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
