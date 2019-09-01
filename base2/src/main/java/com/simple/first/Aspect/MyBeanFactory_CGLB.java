package com.simple.first.Aspect;

import com.simple.first.dao.CustomerDao;
import com.simple.first.dao.CustomerDaoImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description CGLB代理 核心为Enhancer类
 *      setSuperclass() 方法，确定目标对象
 *      setCallback() 方法添加回调函数
 *      create() 方法创建代理类
 * @Author Heling
 * @Date 2019/8/30 13:53
 **/
public class MyBeanFactory_CGLB {
    public static CustomerDao getBean(){
        //准备目标类
        final CustomerDao customerDao = new CustomerDaoImpl();
        //创建切面实例
        final MyAspect myAspect = new MyAspect();
        //生成代理类，CGLB在运行时，生成指定对象的子类增强
        Enhancer enhancer = new Enhancer();
        //确定需要增强的类
        enhancer.setSuperclass(customerDao.getClass());
        //添加回调函数
        enhancer.setCallback(new MethodInterceptor() {
            //interceptor相当于JDK的invoke 前三个参数一致
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                myAspect.myBefore();
                Object obj = method.invoke(customerDao,objects);
                myAspect.myAfter();
                return obj;
            }
        });

        //创建代理类
        CustomerDao customerDao1 = (CustomerDao) enhancer.create();
        return customerDao1;
    }
}
