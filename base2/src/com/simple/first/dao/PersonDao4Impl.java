package com.simple.first.dao;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/30 10:02
 **/
public class PersonDao4Impl implements PersonDao {
    private String name;
    private int age;

    public PersonDao4Impl() {
    }

    public PersonDao4Impl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonDao4Impl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public void add() {
        System.out.println("PersonDao4Impl add execute");
    }
}
