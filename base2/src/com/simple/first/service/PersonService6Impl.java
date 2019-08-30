package com.simple.first.service;

import com.simple.first.dao.PersonDao;
import com.simple.first.dao.PersonDao6Impl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description 本类的注解相当于XML注解
 *       <bean id="personService6"class="com.simple.first.service.PersonService6Impl">
 *            <property name="personDao6"ref="personDao6"/>
 *       </bean>
 * @Author Heling
 * @Date 2019/8/30 10:40
 **/
@Service("personService6")
public class PersonService6Impl implements PersonService {
    @Resource(name = "personDao6")
    private PersonDao persondao6;

    public PersonDao getPersondao6() {
        return persondao6;
    }

    public void setPersondao6(PersonDao persondao6) {
        this.persondao6 = persondao6;
    }

    @Override
    public void addPerson() {
        persondao6.add();
        System.out.println(" PersonService6Impl.addPerson execute.");
    }
}
