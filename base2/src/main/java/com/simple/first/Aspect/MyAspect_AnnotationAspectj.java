package com.simple.first.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description 基于注解的AspectJ切面类
 * @Author Heling
 * @Date 2019/8/30 16:11
 **/
@Aspect
@Component
public class MyAspect_AnnotationAspectj  {
    //用于取代<aop:pointcut
    //  expression="execution( * com.simple.first.dao.*.*(..) )" id="myPointCut"/>
    //要求：方法必须是private，没有值没有自定义，没有参数
    @Pointcut("execution( * com.simple.first.dao.*.*(..) )")
    private void myPointCut(){
    }

    //前置通知
    @Before("myPointCut()")
    public void myBefore(JoinPoint joinPoint){
        System.out.print("前置通知，目标：" );
        System.out.print(joinPoint.getTarget()+ "方法名称：" );
        System.out.println(joinPoint.getSignature().getName());

    }
    //后置通知
    @AfterReturning("myPointCut()")
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.print("后置通知，方法名称：" + joinPoint.getSignature().getName());
    }
    //环绕通知
    @Around("myPointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("环绕开始");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕结束");
        return obj;
    }
    //异常通知
    @AfterThrowing(value = "myPointCut()", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("异常通知 出错了" + e.getMessage());
    }
    //最终通知
    @After("myPointCut()")
    public void myAfter(){
        System.out.println("最终通知");
    }
}
