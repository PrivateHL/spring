package com.simple.first.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author Heling
 * @Date 2019/9/10 11:02
 **/
public class SSH_Service {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring/ApplicationContext_SSH.xml");
        context.start();
    }
}
