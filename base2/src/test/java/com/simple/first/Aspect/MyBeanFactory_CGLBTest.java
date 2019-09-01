package com.simple.first.Aspect;

import com.simple.first.dao.CustomerDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyBeanFactory_CGLBTest {

    @Test
    public void getBean() {
        //从工厂获得指定的内容
        CustomerDao customerDao = MyBeanFactory_CGLB.getBean();
        customerDao.add();
        customerDao.update();
        customerDao.delete();
        customerDao.find();
    }
}