package com.simple.first.Aspect;

import com.simple.first.dao.CustomerDao;
import com.simple.first.dao.CustomerDaoImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description ������ JDK��̬�������
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
        //Proxy.newProxyInstance()�����Ĳ����ֱ��ǣ��������������ʵ����ʵ����Ľӿڣ�������Ҫ��ǿ�ķ�����
    }
}

