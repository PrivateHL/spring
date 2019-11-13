<%--
  Created by IntelliJ IDEA.
  User: heling
  Date: 2019/11/13
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Annotation</title>
</head>
<body>
    <!-- 注释：源码可以看到的注释！-->
    <table><tr><td>源码可以看到注释 </td></tr></table>
    <%-- 注释：源码看不到的注释！--%>
    <table><tr><td>源码看不到注释 </td></tr></table>

    <%!
        int i = 0;
        /**
         @作者：heling
         @功能：该方法用来实现一个简单的计数器
         */
        synchronized void add()
        {
            //单行注释
            i++;
            /* 多行注释*/
        }
    %>
    <% add(); %>
    当前访问次数：<%=i%>

</body>
</html>
