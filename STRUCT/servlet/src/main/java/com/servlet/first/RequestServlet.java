package com.servlet.first;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @Description ����HttpServletRequest
 *      ��ȡ�������еĵķ���
 *      ��ȡ������Ϣͷ�ķ���
 *
 *   extends get post parameters
 *   1.     write a form.html page ,action directed to the servlet post
 *   2.     write the post, get the parameter from getParameter method
 *
 *   extends forward
 *   1.     get the RequestDispatcher instance from request using getRequestDispatcher method
 *   2.     using the instance to forward (or include)
 *   PS:    forward means totally forward the handle power to the other component
 *          while the include means invite the other component helping handing the request.
 *          And more, forward is a inner action, which unseeing by clients, compare to redirect.
 *
 *  expand coding and format
 *      sercletĬ�϶�����ַ�������ڱ���ʱ�����ַ������ ISO-8859-1
 *      ������Խ��յ������ݽ��н���ʱ�������Ĭ�ϵ���� GB2312
 *      In Request
 *          post using $request.setCharacterEncoding("utf-8");  //����request����Ľ��뷽ʽ
 *          get using $name = new String(name.getBytes("iso8859-1"),"utf-8");
 *      In Response
 *          $response.setCharacterEncoding("utf-8");    //���� HttpServletResponseʹ��utf-8����
 *          $response.setHeader("Content-Type", "text/html;charset=utf-8");    //֪ͨ�����ʹ��utf-8����
 *          $response.setContentType("text/html;charset=utf-8");    //������������Ĺ���
 *
 * @Author Heling
 * @Date 2019/11/5 11:38
 **/
public class RequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        PrintWriter out = resp.getWriter();
        printRequest(out,req);
        out.println("<br> HEADER <br>");
        printRequestHeader(out,req);
    }

    private void printRequest(PrintWriter out, HttpServletRequest request){
        // ��ȡ�����е������Ϣ
        out.println("getMethod : " + request.getMethod());
        out.println("getRequestURI:" + request.getRequestURL());
        out.println("getQueryString:" + request.getQueryString());
        out.println("getContextPath:" + request.getContextPath());
        out.println("getServletPath:" + request.getServletPath());
        out.println("getRemoteAddr : " + request.getRemoteAddr());
        out.println("getRemoteHost : " + request.getRemoteHost());
        out.println("getRemotePort : " + request.getRemotePort());
        out.println("getLocalAddr : " + request.getLocalAddr());
        out.println("getLocalName : " + request.getLocalName());
        out.println("getLocalPort : " + request.getLocalPort());
        out.println("getServerName : " + request.getServerName());
        out.println("getServerPort : " + request.getServerPort());
        out.println("getRequestURL : " + request.getRequestURL());
    }

    private void printRequestHeader(PrintWriter out, HttpServletRequest request){
        // ��ȡ������Ϣ�е�����ͷ�ֶ�
        Enumeration headerNames = request.getHeaderNames();
        //��ѭ��������������ͷ����ͨ�� getHeader() ������ȡһ��ָ�����Ƶ�ͷ�ֶ�
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            out.println(headerName + ":" + request.getHeader(headerName) );
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");  //����request����Ľ��뷽ʽ
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("�û���" + name);
        System.out.println("����" + password);
        // ��ȡ������Ϊ"hobby"��ֵ
        String[] hobbys = req.getParameterValues("hobby");
        System.out.println("����:");
        for (int i = 0; i < hobbys.length; i++) {
            System.out.println(hobbys[i] + ",");
        }

        //ת��
        if ( !password.equalsIgnoreCase("123")){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.html");
            dispatcher.forward(req,resp);
//            dispatcher.include(req,resp);
        }
    }
}
