package com.simple.first.service;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AccountServiceImplTest {


    /**
     * ����ʱ��
     * >set global time_zone = '+8:00'; ##�޸�mysqlȫ��ʱ��Ϊ����ʱ�䣬���������ڵĶ�8��
     * > set time_zone = '+8:00'; ##�޸ĵ�ǰ�Ựʱ��
     * > flush privileges; #������Ч
     *���������
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
        // ���Spring������������
        String xmlPath = "spring/ApplicationContext_JDBCTemplate.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
                xmlPath);
        AccountService accountService = (AccountService) applicationContext
                .getBean("accountService");
        accountService.transfer("zhangsan", "lisi", 100);

        //�ضϣ����������ύ�����Ƿ��ع�
        AccountService accountService2 = (AccountService) applicationContext
                .getBean("accountService2");
        accountService2.transfer("zhangsan", "lisi", 100);
    }
}
