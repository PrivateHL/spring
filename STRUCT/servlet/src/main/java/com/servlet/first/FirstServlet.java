package com.servlet.first;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Properties;

/**
 * @Description 手动写一个servlet
 * 1.   extends HttpServlet
 * 2.   overwrite doGet&doPost
 * 3.   declare servlet in file web.xml, include servlet/servlet-mapping
 * 4.   start tomcat service locally on port 8080 with servlet:war exploded(depends on your package way)
 * 5.   visit http://localhost:8080/servlet_war_exploded/first website, a simple web page will be displayed
 *
 * extends: use ServletConfig get servlet config params
 * 1.   write the init config param in web.xml insode label <servlet></servlet>
 * 2.   get ServletConfig instance from the inside Servlet instance, then getInitParameter
 *
 * extends: use ServletContext get global config ,which named context(上下文)
 * 1.   write the config param in web.xml outside label <servlet></servlet> ,difference from ServletConfig
 * 2.   get ServletContext instance, then getInitParameter and getInitParameter
 *
 * extends: use ServletContext read the properties /**
 * 1.   new the properties file in dir resource, and write the keys&values
 * 2.   get ServletContext instance
 * 3.   get the InputStream by context.getResourceAsStream with file name
 * 4.   instance Properties with inputStream
 * @Description:
 * @Author:  HeLing
 * @Date: 2019/11/5 11:15
 */
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);

        //ServletConfig
        ServletConfig config = this.getServletConfig();
        String param = config.getInitParameter("encoding");

        //ServletContext
        ServletContext context = this.getServletContext();
//      得到包含所有初始化参数名的Enumeration对象
//      Enumeration<String> paramNames = context.getInitParameterNames();
        String name = context.getInitParameter("name");
        String addr = context.getInitParameter("address");

        //ServletContext read properties file
        InputStream inputStream = context.getResourceAsStream("/WEB-INF/classes/servlet.properties");
        Properties pros = new Properties();
        pros.load(inputStream);
        String anotherName = pros.getProperty("another-name");
        String anotherAddr = pros.getProperty("another-addr");

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
        out.println("<HTML>");
        out.println("   <HEAD><TITLE> First HANDWrite Servlet </TITLE></HEAD>" );
        out.println("   <BODY>");
        out.print("   This is ");
        out.print(this.getClass());
        out.println(", using the Get method.<br>");
        out.println("   encoding from servlet init-param :" + param );
        out.println("   <br>devloper name    from servlet context config: " + name);
        out.println("   <br>devloper address from servlet context config: " + addr);
        out.println("   <br>another name    from properties file : " + anotherName);
        out.println("   <br>another address from properties file : " + anotherAddr);
        out.println("</BODY>");
        out.println("</HTML>");
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
