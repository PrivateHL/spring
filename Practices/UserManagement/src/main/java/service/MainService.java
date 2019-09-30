package service;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Description
 * @Author Heling
 * @Date 2019/9/30 13:42
 **/
public class MainService {
    public static void main(String[] args) {
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("WEB-INF/applicationContext.xml");
        context.start();
    }
}
