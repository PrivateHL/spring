package com.simple.first.service;

import com.simple.first.dao.PersonDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class PersonServiceImplTest {

    @Test
    public void setPersonDao() {
        //Application �����ļ���·��
        String xmlPath = "ApplicationContext2.xml";
        //��ʼ��spring���������������ļ�
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //������ȡpersonserviceʵ��
        PersonService personService = (PersonService) applicationContext.getBean("personService");
        personService.addPerson();//���棬������������setpersondaoҲ���Ե���person.add()
    }
}