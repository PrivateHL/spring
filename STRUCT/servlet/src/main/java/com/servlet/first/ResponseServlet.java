package com.servlet.first;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description 示范如何返回一个响应
 *      Status 状态码 EG:404 means cannot found the component or resource
 *          setStatus/sendError
 *      Header
 *          addHeader/setHeader/addIntHeader/setContentType/setCharacterEncoding/setLocale
 *      Message Body
 *          getOutputStream/getWriter
 *
 * extends redirect response
 *
 * @Author Heling
 * @Date 2019/11/6 10:18
 **/
public class ResponseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        resp.setContentType("text/html;charset=utf-8");
        // 用 HttpServletRequest 对象的 getParameter() 方法获取用户名和密码
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // 假设用户名和密码分别为 admin 和 123456
        if ("admin".equals(username) && ("123").equals(password)) {
            // 如果用户名和密码正确，重定向到 welcome.html
            resp.sendRedirect("/servlet_war_exploded/welcome.html");
        } else {
            // 如果用户名和密码错误，重定向到 login.html
            resp.sendRedirect("/servlet_war_exploded/login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
