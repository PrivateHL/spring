package com.simple.first.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PersonDao4ImplTest {

    @Test
    public void toStringTest() {
        //Application 配置文件的路径
        String xmlPath = "com/simple/first/ApplicationContext2.xml";
        //初始化spring容器，加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        //通过容器获取persondao实例
        PersonDao personDao = (PersonDao) applicationContext.getBean("personDao4");
        //调用方法
        System.out.println(personDao);
    }
}