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
 * @Description 分析HttpServletRequest
 *      获取请求行行的的方法
 *      获取请求消息头的方法
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
 *      serclet默认对象的字符输出流在编码时采用字符码表是 ISO-8859-1
 *      浏览器对接收到的数据进行解码时，会采用默认的码表 GB2312
 *      In Request
 *          post using $request.setCharacterEncoding("utf-8");  //设置request对象的解码方式
 *          get using $name = new String(name.getBytes("iso8859-1"),"utf-8");
 *      In Response
 *          $response.setCharacterEncoding("utf-8");    //设置 HttpServletResponse使用utf-8编码
 *          $response.setHeader("Content-Type", "text/html;charset=utf-8");    //通知浏览器使用utf-8解码
 *          $response.setContentType("text/html;charset=utf-8");    //包含上面两句的功能
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
        // 获取请求行的相关信息
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
        // 获取请求消息中的所有头字段
        Enumeration headerNames = request.getHeaderNames();
        //用循环遍历所有请求头，并通过 getHeader() 方法获取一个指定名称的头字段
        while (headerNames.hasMoreElements()) {
            String headerName = (String) headerNames.nextElement();
            out.println(headerName + ":" + request.getHeader(headerName) );
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        req.setCharacterEncoding("utf-8");  //设置request对象的解码方式
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("用户名" + name);
        System.out.println("密码" + password);
        // 获取参数名为"hobby"的值
        String[] hobbys = req.getParameterValues("hobby");
        System.out.println("爱好:");
        for (int i = 0; i < hobbys.length; i++) {
            System.out.println(hobbys[i] + ",");
        }

        //转发
        if ( !password.equalsIgnoreCase("123")){
            RequestDispatcher dispatcher = req.getRequestDispatcher("/error.html");
            dispatcher.forward(req,resp);
//            dispatcher.include(req,resp);
        }
    }
}
