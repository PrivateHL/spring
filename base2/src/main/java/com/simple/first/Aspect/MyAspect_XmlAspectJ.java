package com.simple.first.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @Description AspectJ XML����������ʽ���������
 * ��Ҫ����
 *           <dependency>
 *              <groupId>org.aspectj</groupId>
 *              <artifactId>com.springsource.org.aspectj.weaver</artifactId>
 *              <version>1.7.2.RELEASE</version>
 *          </dependency>
 * @Author Heling
 * @Date 2019/8/30 14:48
 **/
public class MyAspect_XmlAspectJ {
    //ǰ��֪ͨ
    public void myBefore(JoinPoint joinPoint){
        System.out.print("ǰ��֪ͨ��Ŀ�꣺" );
        System.out.print(joinPoint.getTarget()+ "�������ƣ�" );
        System.out.println(joinPoint.getSignature().getName());

    }
    //����֪ͨ
    public void myAfterReturning(JoinPoint joinPoint){
        System.out.print("����֪ͨ���������ƣ�" + joinPoint.getSignature().getName());
    }
    //����֪ͨ
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("���ƿ�ʼ");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("���ƽ���");
        return obj;
    }
    //�쳣֪ͨ
    public void myAfterThrowing(JoinPoint joinPoint, Throwable e){
        System.out.println("�쳣֪ͨ ������" + e.getMessage());
    }
    //����֪ͨ
    public void myAfter(){
        System.out.println("����֪ͨ");
    }

}
