package com.simple.first.dao;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/30 10:02
 **/
public class PersonDao5Impl implements PersonDao {
    private String name;
    private int age;

    public PersonDao5Impl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonDao5Impl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void add() {
        System.out.println("personDao5Impl add execute");
    }
}
