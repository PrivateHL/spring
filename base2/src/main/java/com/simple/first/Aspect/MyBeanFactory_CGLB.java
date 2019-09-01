package com.simple.first.Aspect;

import com.simple.first.dao.CustomerDao;
import com.simple.first.dao.CustomerDaoImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description CGLB���� ����ΪEnhancer��
 *      setSuperclass() ������ȷ��Ŀ�����
 *      setCallback() ������ӻص�����
 *      create() ��������������
 * @Author Heling
 * @Date 2019/8/30 13:53
 **/
public class MyBeanFactory_CGLB {
    public static CustomerDao getBean(){
        //׼��Ŀ����
        final CustomerDao customerDao = new CustomerDaoImpl();
        //��������ʵ��
        final MyAspect myAspect = new MyAspect();
        //���ɴ����࣬CGLB������ʱ������ָ�������������ǿ
        Enhancer enhancer = new Enhancer();
        //ȷ����Ҫ��ǿ����
        enhancer.setSuperclass(customerDao.getClass());
        //��ӻص�����
        enhancer.setCallback(new MethodInterceptor() {
            //interceptor�൱��JDK��invoke ǰ��������һ��
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                myAspect.myBefore();
                Object obj = method.invoke(customerDao,objects);
                myAspect.myAfter();
                return obj;
            }
        });

        //����������
        CustomerDao customerDao1 = (CustomerDao) enhancer.create();
        return customerDao1;
    }
}
