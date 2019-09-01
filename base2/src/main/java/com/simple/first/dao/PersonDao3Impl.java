package com.simple.first.dao;

/**
 * @Description 实例工厂方式实例化
 * @Author Heling
 * @Date 2019/8/30 9:36
 **/
public class PersonDao3Impl implements PersonDao {
    @Override
    public void add() {
        System.out.println("PersonDao3Impl add execute");
    }
}
