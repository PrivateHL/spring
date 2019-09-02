package com.simple.first.ssh;

import java.io.Serializable;

/**
 * @Description
 * @Author Heling
 * @Date 2019/9/2 11:49
 **/
public class Person implements Serializable {
    private static final long serialVersionUID = -3541561917509006050L;
    private String id;
    private String name;
    public Person() {
    }
    public Person(String name) {
        super();
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
