package com.simple.first.service;

import com.simple.first.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false)
@Service("accountService2")
public class AccountService2Impl implements AccountService {
    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String outer, String inner, int money) {
        this.accountDao.out(outer,money+1);
        // Ä£Äâ¶Ïµç
        int i = 1 / 0;
        this.accountDao.in(inner,money+1);

    }
}
