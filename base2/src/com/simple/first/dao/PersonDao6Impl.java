package com.simple.first.dao;

import org.springframework.stereotype.Repository;

/**
 * @Description ×¢½â×°ÅäBean
 * @Author Heling
 * @Date 2019/8/30 10:27
 **/
@Repository("personDao6")
public class PersonDao6Impl implements PersonDao {
    @Override
    public void add() {
        System.out.println(" PersonDao6Impl.add execute.");
    }
}
