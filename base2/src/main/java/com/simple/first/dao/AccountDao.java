package com.simple.first.dao;

public interface AccountDao {
    //out
    public void out (String outUser, int money);
    public void in (String inUser, int money);
}
