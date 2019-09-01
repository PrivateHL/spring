package com.simple.first.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Description AspectJ XML配置声明方式的切面对象
 * 需要依赖
 *           <dependency>
 *              <groupId>org.aspectj</groupId>
 *              <artifactId>com.springsource.org.aspectj.weaver</artifactId>
 *              <version>1.7.2.RELEASE</version>
 *          </dependency>
 * @Author Heling
 * @Date 2019/8/30 14:48
 **/
public class MyAspect_XmlAspectJ {
    //前置通知
    public void myBefore(JoinPoint joinPoint){
        System.out.print("前置通知，目标：" );
        System.out.print(joinPoint.getTarget()+ "方法名称：" );
        System.out.println(joinPoint.getSignature().getName());

    }
    //后置通知
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.print("后置通知，方法名称：" + joinPoint.getSignature().getName());
    }
    //环绕通知
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕开始");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕结束");
        return obj;
    }
    //异常通知
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("异常通知 出错了" + e.getMessage());
    }
    //最终通知
    public void myAfter(){
        System.out.println("最终通知");
    }

}
