package com.servlet.first;

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
        super.doPost(req, resp);
    }
}
