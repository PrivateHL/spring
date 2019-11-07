package com.servlet.first;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description ʾ����η���һ����Ӧ
 *      Status ״̬�� EG:404 means cannot found the component or resource
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
        // �� HttpServletRequest ����� getParameter() ������ȡ�û���������
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // �����û���������ֱ�Ϊ admin �� 123456
        if ("admin".equals(username) && ("123").equals(password)) {
            // ����û�����������ȷ���ض��� welcome.html
            resp.sendRedirect("/servlet_war_exploded/welcome.html");
        } else {
            // ����û�������������ض��� login.html
            resp.sendRedirect("/servlet_war_exploded/login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
