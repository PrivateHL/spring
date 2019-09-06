package com.simple.first.ssh;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @Description
 * @Author Heling
 * @Date 2019/9/4 13:25
 **/
public class PersonAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    private PersonService personService;
    public PersonService getPersonService() {
        return personService;
    }
    public void setPersonService(PersonService personService) {
        this.personService = personService;
    }
    public String execute() {
        personService.say();
        return SUCCESS;
    }
}
