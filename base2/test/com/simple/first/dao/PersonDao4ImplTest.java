package com.simple.first.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonDao4ImplTest {

    @Test
    public void toStringTest() {
        //Application �����ļ���·��
        String xmlPath = "com/simple/first/ApplicationContext2.xml";
        //��ʼ��spring���������������ļ�
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //ͨ��������ȡpersondaoʵ��
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDao4");
        //���÷���
        System.out.println(personDao);
    }
}