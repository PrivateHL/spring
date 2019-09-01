package com.simple.first.Aspect;

import com.simple.first.dao.CustomerDao;
import com.simple.first.dao.CustomerDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description 代理类 JDK动态切面代理
 * @Author Heling
 * @Date 2019/8/30 13:40
 **/
public class MyBeanFactory {

    public static CustomerDao getBean() {
        final CustomerDao customerDao = new CustomerDaoImpl();
        final MyAspect myAspect = new MyAspect();
        //use proxy
        return (CustomerDao) Proxy.newProxyInstance(
                MyBeanFactory.class.getClassLoader(),
                new Class[]{CustomerDao.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        myAspect.myBefore();
                        Object obj = method.invoke(customerDao, args);
                        myAspect.myAfter();
                        return obj;
                    }
                }
        );
        //Proxy.newProxyInstance()方法的参数分别是：类加载器、创建实例的实现类的接口，代理需要增强的方法。
    }
}

