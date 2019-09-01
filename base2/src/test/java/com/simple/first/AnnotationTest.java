package com.simple.first;

import com.simple.first.controller.PersonAction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/30 11:27
 **/
public class AnnotationTest {
    @Test
    public void test(){
        String xmlPath = "spring/ApplicationContext_Annotation.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        PersonAction personAction = (PersonAction) applicationContext.getBean("personAction");
        personAction.add();
    }
}
