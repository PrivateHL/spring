package com.simple.first.service;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceImplTest {


    /**
     * 设置时区
     * >set global time_zone = '+8:00'; ##修改mysql全局时区为北京时间，即我们所在的东8区
     * > set time_zone = '+8:00'; ##修改当前会话时区
     * > flush privileges; #立即生效
     *建表和数据
     *     CREATE TABLE account (
     *         id INT (11) PRIMARY KEY AUTO_INCREMENT,
     *         username VARCHAR(20) NOT NULL,
     *         money INT DEFAULT NULL
     *     );
     *     INSERT INTO account VALUES (1,'zhangsan',1000);
     *     INSERT INTO account VALUES (2,'lisi',1000);
     *     select * from account
     */
    @Test
    public void transfer() {
        // 获得Spring容器，并操作
        String xmlPath = "spring/ApplicationContext_JDBCTemplate.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                xmlPath);
        AccountService accountService = (AccountService) applicationContext
                .getBean("accountService");
        accountService.transfer("zhangsan", "lisi", 100);

        //截断，测试事务提交错误是否会回滚
        AccountService accountService2 = (AccountService) applicationContext
                .getBean("accountService2");
        accountService2.transfer("zhangsan", "lisi", 100);
    }
}
