package com.simple.first.Aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @Description Aop����
 * @Author Heling
 * @Date 2019/8/30 14:17
 **/
//��Ҫʵ��
public class MyAspect_AOP implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("ִ��ǰ");
        Object obj = methodInvocation.proceed();
        System.out.println("ִ�к�");
        return obj;
    }
}
