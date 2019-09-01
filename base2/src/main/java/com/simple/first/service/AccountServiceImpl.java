package com.simple.first.service;

import com.simple.first.dao.AccountDao;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outer, String inner, int money) {
        this.accountDao.out(outer,money);
        this.accountDao.in(inner,money);

    }
}
