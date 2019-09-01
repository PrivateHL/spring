package com.simple.first.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonServiceImplTest {

    @Test
    public void setPersonDao() {
        //Application 配置文件的路径
        String xmlPath = "spring/ApplicationContext2.xml";
        //初始化spring容器，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //容器获取personservice实例
        PersonService personService = (PersonService) applicationContext.getBean("personService");
        personService.addPerson();//神奇，不用主动调用setpersondao也可以调用person.add()
    }
}