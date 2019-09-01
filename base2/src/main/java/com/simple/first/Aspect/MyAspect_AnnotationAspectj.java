package com.simple.first.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Description ����ע���AspectJ������
 * @Author Heling
 * @Date 2019/8/30 16:11
 **/
@Aspect
@Component
public class MyAspect_AnnotationAspectj  {
    //����ȡ��<aop:pointcut
    //  expression="execution( * com.simple.first.dao.*.*(..) )" id="myPointCut"/>
    //Ҫ�󣺷���������private��û��ֵû���Զ��壬û�в���
    @Pointcut("execution( * com.simple.first.dao.*.*(..) )")
    private void myPointCut(){
    }

    //ǰ��֪ͨ
    @Before("myPointCut()")
    public void myBefore(JoinPoint joinPoint){
        System.out.print("ǰ��֪ͨ��Ŀ�꣺" );
        System.out.print(joinPoint.getTarget()+ "�������ƣ�" );
        System.out.println(joinPoint.getSignature().getName());

    }
    //����֪ͨ
    @AfterReturning("myPointCut()")
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.print("����֪ͨ���������ƣ�" + joinPoint.getSignature().getName());
    }
    //����֪ͨ
    @Around("myPointCut()")
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("���ƿ�ʼ");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("���ƽ���");
        return obj;
    }
    //�쳣֪ͨ
    @AfterThrowing(value = "myPointCut()", throwing = "e")
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("�쳣֪ͨ ������" + e.getMessage());
    }
    //����֪ͨ
    @After("myPointCut()")
    public void myAfter(){
        System.out.println("����֪ͨ");
    }
}
