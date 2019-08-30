package com.simple.first.Aspect;

import com.simple.first.dao.CustomerDao;
import com.simple.first.service.PersonService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MyAspect_AOPTest {
    @Test
    public void test(){
        //Application �����ļ���·��
        String xmlPath = "com/simple/first/ApplicationContext_AOP.xml";
        //��ʼ��spring���������������ļ�
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDaoProxy");
        customerDao.add();
        customerDao.update();
        customerDao.delete();
        customerDao.find();
    }

}