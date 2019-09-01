package com.simple.first.dao;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/30 9:30
 **/
public class MyBeanFactory {
    //ʵ��������ʽ����ʵ�������������ṩһ���޲ι�����
    public MyBeanFactory() {
        System.out.println("personDao3Impl factory instance ing");
    }

    //����BEAN�ľ�̬��������
    public static PersonDao createBean2(){
        return new PersonDao2Impl();
    }

    public PersonDao createBean3(){
        return new PersonDao3Impl();
    }
}
