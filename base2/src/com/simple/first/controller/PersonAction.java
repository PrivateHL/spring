package com.simple.first.controller;

import com.simple.first.service.PersonService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @Description
 * @Author Heling
 * @Date 2019/8/30 10:58
 **/
@Controller("personAction")
public class PersonAction {
    @Resource(name = "personService6")
    private PersonService personService6;

    public PersonService getPersonService6() {
        return personService6;
    }

    public void add(){
        personService6.addPerson();
        System.out.println(" PersonAction.add execute.");
    }
}
