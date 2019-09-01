package com.simple.first.Aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Description Aop代理
 * @Author Heling
 * @Date 2019/8/30 14:17
 **/
//需要实现
public class MyAspect_AOP implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("执行前");
        Object obj = methodInvocation.proceed();
        System.out.println("执行后");
        return obj;
    }
}
