package com.simple.first.service;

import com.simple.first.dao.PersonDao;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/29 19:05
 **/
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao;
    //provide a iinterface for DI
    public void setPersonDao(PersonDao personDao){
        this.personDao = personDao;
    }

    @Override
    public void addPerson() {
        personDao.add();
        System.out.println("service addPerson execute");
    }
}
