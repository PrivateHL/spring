package com.simple.first.Aspect;

import com.simple.first.dao.CustomerDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class MyAspect_XmlAspectJTest {
    @Test
    public void test(){
        //Application 配置文件的路径
        String xmlPath = "com/simple/first/ApplicationContext_aspectj.xml";
        //初始化spring容器，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao");
        customerDao.add();
    }

}