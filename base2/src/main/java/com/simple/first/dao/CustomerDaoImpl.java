package com.simple.first.dao;

/**
 * @Description JDK´úÀíÊµÀý
 * @Author Heling
 * @Date 2019/8/30 13:35
 **/
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void add() {
        System.out.println(" CustomerDaoImpl.add execute.");
        //int i=1/0;
    }

    @Override
    public void update() {
        System.out.println(" CustomerDaoImpl.update execute.");
    }

    @Override
    public void delete() {
        System.out.println(" CustomerDaoImpl.delete execute.");
    }

    @Override
    public void find() {
        System.out.println(" CustomerDaoImpl.find execute.");
    }
}
