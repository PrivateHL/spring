package com.simple.first.Aspect;

import com.simple.first.dao.CustomerDao;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyBeanFactoryTest {

    @Test
    public void getBean() {
        CustomerDao customerDao = MyBeanFactory.getBean();
        customerDao.add();
        customerDao.update();
        customerDao.delete();
        customerDao.find();
    }
}