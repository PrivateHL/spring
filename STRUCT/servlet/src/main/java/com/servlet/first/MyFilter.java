package com.servlet.first;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Description 请求过滤器
 *      lifecycle
 *          init-doFilter-destroy
 *      1.  write a filter (implements  javax.servlet.Filter), implement three method:init/doFilter/destroy
 *      2.  declare the filter in web.xml,using <filter/><filter-mapping/>
 *      3.  <dispatcher>FORWARD</dispatcher> explicit filter handle which kind of request source（request/include/forward/error）
 *      4.  if there's more filter,they will array by the order in web.xml in the filterChain, filterChain.doFilter will find the next filter
 *      5.  if there are any init-param in the web.xml <Filter></>, you can using FilterConfig instance to get it.
 * @Author Heling
 * @Date 2019/11/6 10:54
 **/
public class MyFilter implements  Filter {
    private String characterEncoding;
    FilterConfig fc;

    public void init(FilterConfig filterConfig) throws ServletException {
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        characterEncoding = fc.getInitParameter("Encoding");
        System.out.println("encoding初始化参数的值为：" + characterEncoding);
        PrintWriter out = servletResponse.getWriter();
        out.write("Hello MyFilter dealled");
//        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
