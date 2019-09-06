package com.simple.first.ssh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class PersonTest {

    ClassPathXmlApplicationContext ctx;
    @Before
    public void loadCtx() {
        // 加载配置文件
        ctx = new ClassPathXmlApplicationContext(
                "spring/ApplicationContext_SSH.xml");
    }
    @Test
    public void testHibernate() {
        SessionFactory sf = (SessionFactory) ctx.getBean("sessionFactory");
        Session session = sf.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(new Person("用户1"));
        transaction.commit();
        session.close();
        sf.close();
    }

    @Test
    public void testStruts2(){
        PersonService ts = (PersonService)ctx.getBean("personService_SSH");
        ts.say();
    }
}