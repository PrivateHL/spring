package com.simple.first.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @Description 注解方式aspectJ的切面目标
 * @Author Heling
 * @Date 2019/8/30 16:20
 **/
@Repository("customerDao2")
public class CustomerDao2Impl implements CustomerDao {
    @Override
    public void add() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void find() {

    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {

    }
}
