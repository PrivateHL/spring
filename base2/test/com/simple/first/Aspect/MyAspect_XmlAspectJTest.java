package com.simple.first.Aspect;

import com.simple.first.dao.CustomerDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MyAspect_XmlAspectJTest {
    @Test
    public void test(){
        //Application �����ļ���·��
        String xmlPath = "com/simple/first/ApplicationContext_aspectj.xml";
        //��ʼ��spring���������������ļ�
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao");
        customerDao.add();
    }

}