package com.simple.first.dao;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/30 9:30
 **/
public class MyBeanFactory {
    //实例工厂方式生成实例，工厂必须提供一个无参构造器
    public MyBeanFactory() {
        System.out.println("personDao3Impl factory instance ing");
    }

    //创建BEAN的静态工厂方法
    public static PersonDao createBean2(){
        return new PersonDao2Impl();
    }

    public PersonDao createBean3(){
        return new PersonDao3Impl();
    }
}
