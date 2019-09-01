package com.simple.first.Aspect;

import com.simple.first.dao.CustomerDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAspect_AnnotationAspectjTest {
    @Test
    public void test(){

        String xmlPath = "spring/ApplicationContext_aspectjAnnotation.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        CustomerDao customerDao = (CustomerDao) applicationContext.getBean("customerDao2");
        customerDao.add();
    }

}