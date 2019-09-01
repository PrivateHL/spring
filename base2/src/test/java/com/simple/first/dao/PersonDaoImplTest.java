package com.simple.first.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonDaoImplTest {

    @Test
    public void add() {
        //Application �����ļ���·��
        String xmlPath = "spring/ApplicationContext2.xml";
        //��ʼ��spring���������������ļ�
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //ͨ��������ȡpersondaoʵ��
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDao");
        //���÷���
        personDao.add();
    }
}