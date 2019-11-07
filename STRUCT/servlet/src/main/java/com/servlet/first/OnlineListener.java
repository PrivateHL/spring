package com.servlet.first;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @Description 使用监听器做一个统计在线人数的功能
 *      1.  write the Listener implements HttpSessionListener, override the sessionCreated/sessionDestroyed
 *      2.  declare the listener in web.xml
 * @Author Heling
 * @Date 2019/11/7 17:07
 **/
public class OnlineListener implements HttpSessionListener {
    private int intOnlinePersonCount = 0;
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        intOnlinePersonCount ++;
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        context.setAttribute("intOnlinePersonCount", new Integer(intOnlinePersonCount));
    }

    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        intOnlinePersonCount--;
        ServletContext context = httpSessionEvent.getSession().getServletContext();
        context.setAttribute("intOnlinePersonCount", new Integer(intOnlinePersonCount));
    }
}
